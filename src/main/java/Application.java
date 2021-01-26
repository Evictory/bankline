import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.TransactionType;
import enums.AccountType;
import static enums.AccountType.*;


import model.Account;
import model.ChartOfAccount;
import model.Transaction;
import model.User;

import service.AccountService;
import service.ChartOfAccountService;
import service.TransactionService;
import service.UserService;


public class Application {
    public static void main(String[] args) {

        createUser(createAccounts());
        Account account = findAccountByLoginAndType("NovoEmerson", CA);
        ChartOfAccount chartOfAccount = createChartOfAccount();

        createTransaction(account, chartOfAccount);
    }

    public static Account findAccountByLoginAndType(String login, AccountType type){
        AccountService accountService = new AccountService();

        return accountService.findAccountByLoginAndType(login, type);
    }

    public static List<Account> createAccounts(){
        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account();
        Account account2 = new Account();

        account1.setInitials(CA);
        account1.setName(CA.name);
        account1.setBalance(333.30);

        account2.setInitials(SA);
        account2.setName(CC.name);
        account2.setBalance(37.80);

        accounts.add(account1);
        accounts.add(account2);

        return accounts;
    }

    public static User createUser(List<Account> accounts){
        User user = new User();
        UserService service = new UserService();

        user.setLogin("NovoEmerson");
        user.setCpf("222333222");
        user.setName("Emerson Transação");
        user.setPassword("2322232");

        user.addAccounts(accounts);

        service.save(user);

        return user;
    }

    public static ChartOfAccount createChartOfAccount(){
        ChartOfAccountService service = new ChartOfAccountService();
        ChartOfAccount chartOfAccount = new ChartOfAccount();

        chartOfAccount.setChartOfAccount("Despesas educacionais");
        chartOfAccount.setTransactionType(TransactionType.EXPENDITURE);

        service.save(chartOfAccount);

        return chartOfAccount;
    }

    public static void createTransaction(Account account, ChartOfAccount chartOfAccount){
        Transaction transaction = new Transaction();
        TransactionService service = new TransactionService();

        transaction.setAccount(account);
        transaction.setTransactionType(TransactionType.EXPENDITURE);
        transaction.setDate(LocalDate.now());
        transaction.setValue(525.22);
        transaction.setDescription("Gastos no futuro");
        transaction.setChartOfAccount(chartOfAccount);

        service.save(transaction);
    }
}
