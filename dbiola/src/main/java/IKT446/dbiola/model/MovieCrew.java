package IKT446.dbiola.model;

import IKT446.dbiola.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovieCrew extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "crew_member_id", referencedColumnName = "id")
    private CrewMember crewMember;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private CrewJob job;

    private String creditId;

    public MovieCrew() { super(); }

    public MovieCrew(Movie movie, CrewMember crewMember, CrewJob job, String creditId) {
        this.movie = movie;
        this.crewMember = crewMember;
        this.job = job;
        this.creditId = creditId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CrewMember getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(CrewMember crewMember) {
        this.crewMember = crewMember;
    }

    public CrewJob getJob() {
        return job;
    }

    public void setJob(CrewJob job) {
        this.job = job;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }
}
