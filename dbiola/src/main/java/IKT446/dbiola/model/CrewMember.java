package IKT446.dbiola.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CrewMember {

    @Id
    private Long id;
    private String name;
    private Integer gender;

    public CrewMember() {}

    public CrewMember(Long id, String name, Integer gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
