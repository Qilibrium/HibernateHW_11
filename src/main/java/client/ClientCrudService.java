package client;

import Storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    public String readClientById(long id){
        Session session = util.getSessionFactory().openSession();
        Client client = session.get(Client.class,id);
        System.out.println("client = " + client);
        session.close();
        return String.valueOf(client);
    }

    public void updateClientById(long id, String name){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client update = session.get(Client.class,id);
        String s = update.setName(name);
        session.persist(update);
        System.out.println("update = " + s);
        transaction.commit();
        session.close();

    }
    public void deleteClientById(long id){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client clientDeleteById = session.get(Client.class,id);
        session.remove(clientDeleteById);
        transaction.commit();
        session.close();
    }

    }



