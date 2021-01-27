package repository;

import enums.AccountType;
import model.Account;

import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Account> getTotalBalanceByLogin(String login){
        String select = "select a from Account a where a.user.login = :login";
        TypedQuery<Account> query = this.entityManager.createQuery(select, Account.class);

        query.setParameter("login", login);
        List<Account> accounts = query.getResultList();

        return accounts;
    }
}
