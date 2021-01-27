package service;

import enums.AccountType;
import model.Account;
import repository.AccountRepository;

import java.util.List;

public class AccountService {
    public void save(Account account){
        AccountRepository repository = new AccountRepository();
        repository.save(account);
    }

    public Account findAccountByLoginAndType(String login, AccountType type){
        AccountRepository accountRepository = new AccountRepository();

        return accountRepository.findAccountByLoginAndType(login, type);
    }

    //implementar
    public Account getTotalBalanceByLogin(String login){
        AccountRepository accountRepository = new AccountRepository();
        List<Account> accounts = accountRepository.getTotalBalanceByLogin(login);

        return new Account();
    }
}
