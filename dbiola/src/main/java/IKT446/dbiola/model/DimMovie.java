package IKT446.dbiola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DimMovie {

    @Id
    @Column(name = "movie_id")
    private Long movieId;
    private String title;
    private Double popularity;
    private Double rating;
    private Integer votes;
    private Integer runtime;

    public DimMovie() {}

    public DimMovie(Long movieId, String title, Double popularity, Double rating, Integer votes, Integer runtime) {
        this.movieId = movieId;
        this.title = title;
        this.popularity = popularity;
        this.rating = rating;
        this.votes = votes;
        this.runtime = runtime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
}
