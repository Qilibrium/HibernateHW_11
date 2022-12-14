package planet;
import Storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class PlanetCrudService {
    private final HibernateUtil util = HibernateUtil.getInstance();

    public void createPlanetById(String id, String name) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet newPlanet = new Planet();
        newPlanet.setId(id);
        newPlanet.setName(name);
        session.persist(newPlanet);
        transaction.commit();
        session.close();
    }
    public void readPlanetById(String id){
        Session session = util.getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        String name = planet.getName();
        System.out.println("name = " + name);
        session.close();
    }
    public void updatePlanetById(String id, String name){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet updatePlanet=session.get(Planet.class,id);
        updatePlanet.setName(name);
        session.persist(updatePlanet);
        transaction.commit();
        session.close();
    }

    public void deletePlanetById(String id){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet deletePlanet = session.get(Planet.class,id);
        session.remove(deletePlanet);
        transaction.commit();
        session.close();
    }
    public void getAllPlanets(){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        for (Planet planet : planets) {
            System.out.println(planet);
        }
        System.out.println("\n================\n");
        transaction.commit();
        session.close();

    }
}



