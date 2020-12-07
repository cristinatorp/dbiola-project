package IKT446.dbiola.api;

import IKT446.dbiola.exception.MovieNotFoundException;
import IKT446.dbiola.model.DimMovie;
import IKT446.dbiola.model.FactRevenue;
import IKT446.dbiola.model.Movie;
import IKT446.dbiola.repository.DimMovieRepo;
import IKT446.dbiola.repository.FactRevenueRepo;
import IKT446.dbiola.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UpdateController {

    private final String TMDBDetailBaseUrl = "https://api.themoviedb.org/3/movie/";
    private final String TMDBapiKey;
    private final MovieRepo movieRepo;
    private final FactRevenueRepo factRepo;
    private final DimMovieRepo dimMovieRepo;

    @Autowired
    public UpdateController(MovieRepo movieRepo,
                            FactRevenueRepo factRepo,
                            DimMovieRepo dimMovieRepo,
                            @Value("${dbiola.tmdb_api_key}") String TMDBapiKey) {
        this.movieRepo = movieRepo;
        this.factRepo = factRepo;
        this.dimMovieRepo = dimMovieRepo;
        this.TMDBapiKey = TMDBapiKey;
    }

    @Scheduled(cron = "0 12 * * * *")
    public void updateODB() {
        List<Movie> existingMovies = movieRepo.findAll();
        List<Movie> outdatedMovies = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        int epoch = 1;
        int movieCount = existingMovies.size();
        for (Movie movie : existingMovies) {
            System.out.println("[" + epoch + "/" + movieCount + "] " + movie.getTitle());
            String url = TMDBDetailBaseUrl + movie.getId() + "?api_key=6eb9d7e83fe6a118252d38a94eaac143&language=en-US";

            try {
                String TMDBresult = restTemplate.getForObject(url, String.class);
                JSONObject jsonMovie = new JSONObject(TMDBresult);

                movie.setBudget(jsonMovie.getLong("budget"));
                movie.setRevenue(jsonMovie.getLong("revenue"));
                movie.setPopularity(jsonMovie.getDouble("popularity"));
                movie.setVotes(jsonMovie.getInt("vote_count"));
                movie.setRating(jsonMovie.getDouble("vote_average"));
            } catch(HttpClientErrorException err) {
                err.printStackTrace();
                outdatedMovies.add(movie);
                continue;
            } catch (JSONException err) {
                err.printStackTrace();
                continue;
            }

            epoch++;
        }

        System.out.println("\nCould not retrieve updates for the following movies:");
        for (Movie movie : outdatedMovies) {
            System.out.println(movie.getTitle());
        }

        movieRepo.saveAll(existingMovies);
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n" + now.format(dateFormat) + " => Updated movies in ODB");

        updateADB(existingMovies);
    }

    public void updateADB(List<Movie> updatedMovies) {
        List<FactRevenue> factList = factRepo.findAll();
        List<DimMovie> updatedDimMovies = new ArrayList<>();

        int epochs = factList.size();
        int epoch = 1;
        for (FactRevenue fact : factList) {
            System.out.println("[" + epoch + "/" + epochs + "]");

            Long movieId = fact.getMovie().getMovieId();
            Movie updatedMovie = updatedMovies.stream()
                    .filter(movie -> movie.getId().equals(movieId))
                    .findFirst()
                    .orElseThrow(() -> new MovieNotFoundException(movieId));

            DimMovie movie = fact.getMovie();
            movie.setPopularity(updatedMovie.getPopularity());
            movie.setRating(updatedMovie.getRating());
            movie.setVotes(updatedMovie.getVotes());
            updatedDimMovies.add(movie);

            fact.setMovie(movie);
            fact.setRevenue(updatedMovie.getRevenue());
            fact.setBudget(updatedMovie.getBudget());

            epoch++;
        }

        factRepo.saveAll(factList);
        dimMovieRepo.saveAll(updatedDimMovies);
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n" + now.format(dateFormat) + " => Updated ADB");
    }

    public void updateAllODBMovieProperties() {
        List<Movie> existingMovies = movieRepo.findAll();
        List<Movie> outdatedMovies = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        int epoch = 1;
        int movieCount = existingMovies.size();
        for (Movie movie : existingMovies) {
            System.out.println("[" + epoch + "/" + movieCount + "] " + movie.getTitle());
            String url = TMDBDetailBaseUrl + movie.getId() + "?api_key=" + TMDBapiKey + "&language=en-US";

            try {
                String TMDBresult = restTemplate.getForObject(url, String.class);
                JSONObject jsonMovie = new JSONObject(TMDBresult);
                String tagline = jsonMovie.optString("tagline");
                String overview = jsonMovie.optString("overview");
                String status = jsonMovie.optString("status");
                String releaseDate = jsonMovie.optString("release_date");
                int runtime = jsonMovie.optInt("tagline");
                String homepage = jsonMovie.optString("homepage");

                movie.setTitle(jsonMovie.getString("title"));
                movie.setTagline(tagline.equals("") ? null : tagline);
                movie.setOverview(overview.equals("") ? null : overview);
                movie.setReleased(status.equals("") ? null : jsonMovie.getString("status").equals("Released"));
                movie.setReleaseDate(releaseDate.equals("") ? null : LocalDate.parse(releaseDate));
                movie.setOriginalLanguage(jsonMovie.getString("original_language"));
                movie.setBudget(jsonMovie.getLong("budget"));
                movie.setRevenue(jsonMovie.getLong("revenue"));
                movie.setPopularity(jsonMovie.getDouble("popularity"));
                movie.setRuntime(runtime == 0 ? null : runtime);
                movie.setVotes(jsonMovie.getInt("vote_count"));
                movie.setRating(jsonMovie.getDouble("vote_average"));
                movie.setHomepage(homepage.equals("") ? null : homepage);
            } catch(HttpClientErrorException err) {
                err.printStackTrace();
                outdatedMovies.add(movie);
                continue;
            } catch (JSONException err) {
                err.printStackTrace();
                continue;
            }

            epoch++;
        }

        System.out.println("\nCould not retrieve updates for the following movies:");
        for (Movie movie : outdatedMovies) {
            System.out.println(movie.getTitle());
        }

        movieRepo.saveAll(existingMovies);
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n" + now.format(dateFormat) + " => Updated movies in ODB");
    }

}
