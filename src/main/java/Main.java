import Storage.DatabaseInitService;
import Storage.hibernate.HibernateUtil;
import client.Client;
import client.ClientCrudService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import planet.Planet;
import planet.PlanetCrudService;

public class Main {

    public static void main(String[] args) {
   new PlanetCrudService().deletePlanetById("VER");


    }
    }

