package IKT446.dbiola.model;

import IKT446.dbiola.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class SpokenLanguage extends BaseEntity {

    private String code;
    private String language;

    public SpokenLanguage() { super(); }

    public SpokenLanguage(String code, String language) {
        this.code = code;
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
