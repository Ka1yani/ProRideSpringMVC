package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtility {

    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProRidePersistenceUnit");
        EntityManager em = factory.createEntityManager();
        return em;
    }
}
