package service;

import enums.AccountType;
import model.Account;
import repository.AccountRepository;

public class AccountService {
    public void save(Account account){
        AccountRepository repository = new AccountRepository();
        repository.save(account);
    }

    public Account findAccountByLoginAndType(String login, AccountType type){
        AccountRepository accountRepository = new AccountRepository();

        return accountRepository.findAccountByLoginAndType(login, type);
    }
}
