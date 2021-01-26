package repository;

import enums.AccountType;
import model.Account;
import model.User;

import javax.persistence.TypedQuery;

public class UserRepository extends CrudRepository {
    public UserRepository(){
        super();
    }

    public void save(User user) {
        super.save(user);
    }

    //implementar o método
    public Account findByLoginAndType(String login, AccountType type){
        Account account = new Account();
        TypedQuery<Account> query = this.entityManager.createQuery(
                "select a from Account a where a.initials = :type and a.user.login = :login",
                Account.class);

        query.setParameter("type", type);
        query.setParameter("login", login);
        query.getSingleResult();

        return account;
    }
}
