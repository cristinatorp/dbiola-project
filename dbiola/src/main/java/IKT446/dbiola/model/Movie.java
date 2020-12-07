package IKT446.dbiola.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Movie {

    @Id
    private Long id;
    private String title;
    private String tagline;
    private String overview;
    private boolean released;
    private LocalDate releaseDate;
    private String originalLanguage;
    private Long budget;
    private Long revenue;
    private Double popularity;
    private Integer runtime;
    private Integer votes;
    private Double rating;
    private String homepage;

    public Movie() {}

    public Movie(Long id,
                 String title,
                 String tagline,
                 String overview,
                 boolean released,
                 LocalDate releaseDate,
                 String originalLanguage,
                 Long budget,
                 Long revenue,
                 Double popularity,
                 Integer runtime,
                 Integer votes,
                 Double rating,
                 String homepage) {
        this.id = id;
        this.title = title;
        this.tagline = tagline;
        this.overview = overview;
        this.released = released;
        this.releaseDate = releaseDate;
        this.originalLanguage = originalLanguage;
        this.budget = budget;
        this.revenue = revenue;
        this.popularity = popularity;
        this.runtime = runtime;
        this.votes = votes;
        this.rating = rating;
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tagline='" + tagline + '\'' +
                ", overview='" + overview + '\'' +
                ", released=" + released +
                ", releaseDate=" + releaseDate +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", budget=" + budget +
                ", revenue=" + revenue +
                ", popularity=" + popularity +
                ", runtime=" + runtime +
                ", votes=" + votes +
                ", rating=" + rating +
                ", homepage='" + homepage + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
