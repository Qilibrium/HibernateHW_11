package client;

import Storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {
    private final HibernateUtil util = HibernateUtil.getInstance();


    public Client createClientById(String name) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client newClient = new Client();
        newClient.setName(name);
        session.persist(newClient);
        transaction.commit();
        session.close();
        return newClient;
    }

    public Client readClientById(long id) {
        Session session = util.getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public Client updateClientById(long id, String name) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client update = session.get(Client.class, id);
        update.setName(name);
        session.persist(update);
        transaction.commit();
        session.close();
        return update;
    }

    public Client deleteClientById(long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client clientDeleteById = session.get(Client.class, id);
        session.remove(clientDeleteById);
        transaction.commit();
        session.close();
        return clientDeleteById;
    }

    public List<Client> getAllClients() {
        Session session = util.getSessionFactory().openSession();
        List<Client> client = session.createQuery("from Client ", Client.class).list();
        for (Client clients : client) {
            System.out.println(clients);
        }
        System.out.println("\n================\n");
        session.close();

        return client;
    }

    }






