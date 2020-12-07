package IKT446.dbiola.model;

import IKT446.dbiola.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieKeyword extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "keyword_id", referencedColumnName = "id")
    private Keyword keyword;

    public MovieKeyword() { super(); }

    public MovieKeyword(Movie movie, Keyword keyword) {
        this.movie = movie;
        this.keyword = keyword;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
    }
}
