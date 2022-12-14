package client;

import Storage.hibernate.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ClientCrudService {
    private final HibernateUtil util = HibernateUtil.getInstance();


    public String createClientById(String name) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client newClient = new Client();
        newClient.setName(name);
        session.persist(newClient);
        transaction.commit();
        session.close();
        return name;
    }

    public void readClientById(long id) {
        Session session = util.getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        client.getName();
        System.out.println(client);
        session.close();

    }

    public void updateClientById(long id, String name) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client update = session.get(Client.class, id);
        String s = update.setName(name);
        session.persist(update);
        transaction.commit();
        session.close();

    }

    public void deleteClientById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client clientDeleteById = session.get(Client.class, id);
        session.remove(clientDeleteById);
        transaction.commit();
        session.close();
    }

    public void getAllClients() {
        Session session = util.getSessionFactory().openSession();
        List<Client> client = session.createQuery("from Client ", Client.class).list();
        for (Client clients : client) {
            System.out.println(clients);
        }
        System.out.println("\n================\n");
        session.close();

    }

    }






