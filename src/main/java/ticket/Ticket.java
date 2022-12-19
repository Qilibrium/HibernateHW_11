package ticket;

import client.Client;
import jakarta.persistence.*;
import planet.Planet;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;

@Entity

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "created_at")
   private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client_id;
    @ManyToOne
    @JoinColumn(name="from_planet_id", nullable=false)
    private Planet from_planet_id;
    @ManyToOne
    @JoinColumn(name="to_planet_id", nullable=false)
    private Planet to_planet_id;

    public Ticket(Timestamp created_at, Client client_id, Planet from_planet_id, Planet to_planet_id) {
        this.id = id;
        this.created_at = created_at;
        this.client_id = client_id;
        this.from_planet_id = from_planet_id;
        this.to_planet_id = to_planet_id;
    }

    public Ticket() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    public Planet getFrom_planet_id() {
        return from_planet_id;
    }

    public void setFrom_planet_id(Planet from_planet_id) {
        this.from_planet_id = from_planet_id;
    }

    public Planet getTo_planet_id() {
        return to_planet_id;
    }

    public void setTo_planet_id(Planet to_planet_id) {
        this.to_planet_id = to_planet_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", client_id=" + client_id +
                ", from_planet_id=" + from_planet_id +
                ", to_planet_id=" + to_planet_id +
                '}';
    }


}
