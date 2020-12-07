package IKT446.dbiola.model;

import IKT446.dbiola.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieSpokenLanguage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private SpokenLanguage language;

    public MovieSpokenLanguage() { super(); }

    public MovieSpokenLanguage(Movie movie, SpokenLanguage language) {
        this.movie = movie;
        this.language = language;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public SpokenLanguage getLanguage() {
        return language;
    }

    public void setLanguage(SpokenLanguage language) {
        this.language = language;
    }
}
