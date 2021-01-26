package repository;

import model.User;

public class UserRepository extends CrudRepository {
    public UserRepository(){
        super();
    }

    public void save(User user) {
        super.save(user);
    }
}
