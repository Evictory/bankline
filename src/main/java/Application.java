import model.Account;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

import static enums.AccountType.*;

public class Application {
    public static void main(String[] args) {

        User usuario1 = new User();
        Account account1 = new Account();
        Account account2 = new Account();
        List<Account> accounts = new ArrayList<>();

        usuario1.setLogin("emerson2");
        usuario1.setCpf("222333222");
        usuario1.setName("Emerson Vitorio");
        usuario1.setPassword("2322232");

        System.out.println(CA.name);

        account1.setInitials(CA);
        account1.setName(CA.name);
        account1.setBalance(25.30);

        account2.setInitials(CC);
        account2.setName(CC.name);
        account2.setBalance(37.80);

        accounts.add(account1);
        accounts.add(account2);

        usuario1.addAccounts(accounts);

        UserService service = new UserService();
        service.save(usuario1);

    }
}
