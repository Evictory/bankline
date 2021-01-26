package repository;

import util.ConnectionFactoryUseful;
import javax.persistence.EntityManager;

public class CrudRepository <T>{
    //dá para criar um entitymanager protected e passar para os demais repositórios
    protected void save(T data){
        EntityManager connection = ConnectionFactoryUseful.getConnection();
        connection.getTransaction().begin();
        connection.persist(data);
        connection.getTransaction().commit();
    }
}
