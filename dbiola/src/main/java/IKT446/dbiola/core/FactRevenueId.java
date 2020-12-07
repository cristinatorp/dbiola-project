package IKT446.dbiola.core;

import IKT446.dbiola.model.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

public class FactRevenueId implements Serializable {

    private Long movie;
    private Long company;
    private Long country;
    private Long genre;

    public FactRevenueId() {}

    public FactRevenueId(Long movie, Long company, Long country, Long genre) {
        this.movie = movie;
        this.company = company;
        this.country = country;
        this.genre = genre;
    }

    public Long getMovie() {
        return movie;
    }

    public Long getCompany() {
        return company;
    }

    public Long getCountry() {
        return country;
    }

    public Long getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FactRevenueId)) return false;
        FactRevenueId that = (FactRevenueId) o;
        return getMovie().equals(that.getMovie()) &&
                getCompany().equals(that.getCompany()) &&
                getCountry().equals(that.getCountry()) &&
                getGenre().equals(that.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie(), getCompany(), getCountry(), getGenre());
    }
}