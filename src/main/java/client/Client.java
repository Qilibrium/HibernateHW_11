package client;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="client")
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public String toString() {
        return "Client.Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
