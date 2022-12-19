package ticket;
import Storage.hibernate.HibernateUtil;
import client.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import planet.Planet;


import java.sql.Timestamp;
import java.util.List;

public class TicketCrudService {
    private final HibernateUtil util = HibernateUtil.getInstance();

    public Ticket createTicket( String client_id, String from_planet_id, String to_planet_id){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client newClient = new Client();
        newClient.setName(client_id);
        Session sessionPlanetFrom= util.getSessionFactory().openSession();
        Session sessionPlanetTo = util.getSessionFactory().openSession();
        Ticket newTicket = new Ticket();
        newTicket.setCreated_at(new Timestamp(System.currentTimeMillis()));
        newTicket.setClient_id(newClient);
        newTicket.setFrom_planet_id(sessionPlanetFrom.get(Planet.class, from_planet_id));
        newTicket.setTo_planet_id(sessionPlanetTo.get(Planet.class, to_planet_id));
        session.persist(newClient);
        session.persist(newTicket);
        transaction.commit();
        session.close();
        return newTicket;
    }

    public Ticket readTicketById(long id){
        Session session = util.getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public List<Ticket> getAllTickets(){
        Session session = util.getSessionFactory().openSession();
        List<Ticket> from_tickets = session.createQuery("from Ticket", Ticket.class).list();
        for (Ticket tickets : from_tickets) {
            System.out.println("tickets = " + tickets);
        }
        System.out.println("\n================\n");
        session.close();

        return from_tickets;
    }

    public Ticket updateTicketBiId(long id, String client_id, String from_planet_id, String to_planet_id){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket updateTicket = session.get(Ticket.class, id);

        Client updateClient = new Client();
        updateClient.setName(client_id);
        session.persist(updateClient);
        updateTicket.setClient_id(updateClient);

        Session sessionPlanetFrom= util.getSessionFactory().openSession();
        Session sessionPlanetTo = util.getSessionFactory().openSession();

        updateTicket.setCreated_at(new Timestamp(System.currentTimeMillis()));
        updateTicket.setFrom_planet_id(sessionPlanetFrom.get(Planet.class, from_planet_id));
        updateTicket.setTo_planet_id(sessionPlanetTo.get(Planet.class, to_planet_id));

        session.persist(updateTicket);
        transaction.commit();
        session.close();
        return updateTicket;
    }

    public Ticket deleteTicketById(long id){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket deleteTicket = session.get(Ticket.class, id);
        session.remove(deleteTicket);
        transaction.commit();
        session.close();
        return deleteTicket;
    }
}
