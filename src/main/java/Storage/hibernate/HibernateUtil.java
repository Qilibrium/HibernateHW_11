package Storage.hibernate;
import client.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import planet.Planet;
import ticket.Ticket;

import java.util.List;

public class HibernateUtil {
    private final SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    private static final HibernateUtil INSTANCE;

    static {
        INSTANCE = new HibernateUtil();
    }
    private HibernateUtil(){
        sessionFactory= new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }
    public static HibernateUtil getInstance(){
        return INSTANCE;
    }

    public void close(){
        sessionFactory.close();
    }

    }

