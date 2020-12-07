package IKT446.dbiola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DimCompany {

    @Id
    @Column(name = "company_id")
    private Long companyId;
    private String company;

    public DimCompany() {}

    public DimCompany(Long companyId, String company) {
        this.companyId = companyId;
        this.company = company;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
