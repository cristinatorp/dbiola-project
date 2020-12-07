package IKT446.dbiola.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {

    @Id
    private Long id;
    private String name;
    private int gender;

    public Actor() {}

    public Actor(Long id, String name, int gender) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
