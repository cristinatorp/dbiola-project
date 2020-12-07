package IKT446.dbiola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DimCountry {

    @Id
    @Column(name = "country_id")
    private Long countryId;
    private String code;
    private String country;

    public DimCountry() {}

    public DimCountry(Long countryId, String code, String country) {
        this.countryId = countryId;
        this.code = code;
        this.country = country;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
