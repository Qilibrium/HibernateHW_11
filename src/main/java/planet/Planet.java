package planet;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    public Planet(){

    }

    @Id
    @Column(name = "id",unique=true,columnDefinition="VARCHAR(4)")
    private String id;
@Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
