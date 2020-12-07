package IKT446.dbiola.model;

import IKT446.dbiola.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieProdCountry extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private ProductionCountry country;

    public MovieProdCountry() { super(); }

    public MovieProdCountry(Movie movie, ProductionCountry country) {
        this.movie = movie;
        this.country = country;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ProductionCountry getCountry() {
        return country;
    }

    public void setCountry(ProductionCountry country) {
        this.country = country;
    }
}
