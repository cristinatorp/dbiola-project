package IKT446.dbiola.model;

import IKT446.dbiola.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class CrewJob extends BaseEntity {

    private String job;
    private String department;

    public CrewJob(){ super(); }

    public CrewJob(String job, String department) {
        this.job = job;
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
