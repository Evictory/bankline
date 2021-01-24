package repository;

import model.User;
import util.ConnectionFactoryUseful;

import javax.persistence.EntityManager;

public class UserRepository {
    public static void save(User user){
        EntityManager connection = ConnectionFactoryUseful.getConnection();

        connection.getTransaction().begin();
        connection.persist(user);
        connection.getTransaction().commit();
    }
}
