package IKT446.dbiola.api;

import IKT446.dbiola.repository.GenreRepo;
import IKT446.dbiola.repository.MovieGenreRepo;
import IKT446.dbiola.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/genre")
public class MovieGenreController {

    private final MovieGenreRepo movieGenreRepo;
    private final MovieRepo movieRepo;
    private final GenreRepo genreRepo;

    @Autowired
    public MovieGenreController(MovieGenreRepo movieGenreRepo,
                                MovieRepo movieRepo,
                                GenreRepo genreRepo) {
        this.movieGenreRepo = movieGenreRepo;
        this.movieRepo = movieRepo;
        this.genreRepo = genreRepo;
    }

}
