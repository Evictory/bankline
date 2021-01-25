import model.Account;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

import static enums.AccountType.CA;
import static enums.AccountType.CC;

public class Application {
    public static void main(String[] args) {

        User usuario1 = new User();
        Account account1 = new Account();
        Account account2 = new Account();
        List<Account> accounts = new ArrayList<>();

        usuario1.setLogin("leticia1");
        usuario1.setCpf("11122233344");
        usuario1.setName("Leticia Leticia");
        usuario1.setPassword("22");

        account1.setInitials(CA.name());
        account1.setName(CA);
        account1.setBalance(25.30);

        account2.setInitials(CC.name());
        account2.setName(CC);
        account2.setBalance(37.80);

        accounts.add(account1);
        accounts.add(account2);

        usuario1.addAccounts(accounts);

        UserService service = new UserService();
        service.save(usuario1);

    }
}
