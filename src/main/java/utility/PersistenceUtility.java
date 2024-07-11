package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtility {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProRidePersistenceUnit");

    public static EntityManager getEntityManager(){
        EntityManager em = factory.createEntityManager();
        return em;
    }

    public static void cleanUp() {
       factory.close();
    }


}
