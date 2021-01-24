import model.Account;
import model.User;
import service.UserService;

import static enums.AccountType.CA;

public class Application {
    public static void main(String[] args) {

        User usuario1 = new User();
        Account account = new Account();

        account.setInitials(CA.name());
        account.setName(CA);
        account.setBalance(25.30);

        usuario1.setLogin("leticia1");
        usuario1.setCpf("11122233344");
        usuario1.setName("Leticia Leticia");
        usuario1.setPassword("22");


        UserService service = new UserService();
        service.save(usuario1);

    }
}
