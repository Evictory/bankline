package repository;

import enums.AccountType;
import model.Account;

import javax.persistence.TypedQuery;

public class AccountRepository extends CrudRepository {
    public AccountRepository(){
        super();
    }

    public void save(Account account) {
        super.save(account);
    }

    public Account findAccountByLoginAndType(String login, AccountType type){
        String select = "select a from Account a where a.initials = :type and a.user.login = :login";
        TypedQuery<Account> query = this.entityManager.createQuery(select, Account.class);

        query.setParameter("type", type);
        query.setParameter("login", login);
        Account account = query.getSingleResult();

        return account;
    }
}
