package IKT446.dbiola.model;

import IKT446.dbiola.core.FactRevenueId;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(FactRevenueId.class)
public class FactRevenue {

    @Id
    @OneToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private DimMovie movie;

    @Id
    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private DimCompany company;

    @Id
    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private DimCountry country;

    @Id
    @OneToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private DimGenre genre;

    private LocalDate releaseDate;
    private Long revenue;
    private Long budget;

    public FactRevenue() {}

    public FactRevenue(DimMovie movie, DimCompany company, DimCountry country, DimGenre genre, LocalDate releaseDate, Long revenue, Long budget) {
        this.movie = movie;
        this.company = company;
        this.country = country;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.budget = budget;
    }

    public DimMovie getMovie() {
        return movie;
    }

    public void setMovie(DimMovie movie) {
        this.movie = movie;
    }

    public DimCompany getCompany() {
        return company;
    }

    public void setCompany(DimCompany company) {
        this.company = company;
    }

    public DimCountry getCountry() {
        return country;
    }

    public void setCountry(DimCountry country) {
        this.country = country;
    }

    public DimGenre getGenre() {
        return genre;
    }

    public void setGenre(DimGenre genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}
