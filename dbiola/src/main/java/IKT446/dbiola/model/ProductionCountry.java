package IKT446.dbiola.model;

import IKT446.dbiola.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class ProductionCountry extends BaseEntity {

    private String code;
    private String country;

    public ProductionCountry() { super(); }

    public ProductionCountry(String code, String country) {
        this.code = code;
        this.country = country;
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
