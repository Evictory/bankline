package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactoryUseful {
    private static EntityManager entityManager;

    public static EntityManager getConnection(){
        if(entityManager == null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("peoplExceptionUnit");
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }
}
