package model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_user", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}, name = "uk_user_login"))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    private String login;

    private String name;
    private String cpf;
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_login", referencedColumnName = "login")
    private List<Account> accounts = new ArrayList<>();

    @Embedded
    private DateUseful date = new DateUseful();

    public User() {}

    public User(String login, String name, String cpf, String password, List<Account> accounts, DateUseful date) {
        this.login = login;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.accounts = accounts;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addAccounts(List<Account> accounts) {
        this.accounts.addAll(accounts);
        accounts.forEach(account -> account.setUser(this));
    }

    public DateUseful getDate() {
        return date;
    }

    public void setDate(DateUseful date) {
        this.date = date;
    }

    public List<Account> getAccounts(){
        return this.accounts;
    }

}
