package IKT446.dbiola.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductionCompany {

    @Id
    private Long id;
    private String company;

    public ProductionCompany() {}

    public ProductionCompany(Long id, String company) {
        this.id = id;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
