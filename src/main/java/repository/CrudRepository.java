package repository;

import util.ConnectionFactoryUseful;
import javax.persistence.EntityManager;

public class CrudRepository <T>{
    protected EntityManager entityManager = ConnectionFactoryUseful.getConnection();
    protected void save(T data){
        entityManager.getTransaction().begin();
        entityManager.persist(data);
        entityManager.getTransaction().commit();
    }
}
