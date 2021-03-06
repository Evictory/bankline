package model;

import enums.AccountType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_account", uniqueConstraints = @UniqueConstraint(columnNames = {"user_login", "initials"}, name = "uk_account"))
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AccountType initials;
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login", referencedColumnName = "login", nullable = false, foreignKey = @ForeignKey(name = "pk_login"))
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="account_id")
    private List<Transaction> transactions = new ArrayList<>();

    @Embedded
    private DateUseful date = new DateUseful();

    public Account() {}

    public Account(String name, AccountType initials, Double balance, User user, List<Transaction> transactions, DateUseful date) {
        this.name = name;
        this.initials = initials;
        this.balance = balance;
        this.user = user;
        this.transactions = transactions;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum<AccountType> getInitials() {
        return initials;
    }

    public void setInitials(AccountType initials) {
        this.initials = initials;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addTransactions(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
        transactions.forEach(transaction -> transaction.setAccount(this));
    }

    public DateUseful getDate() {
        return date;
    }

    public void setDate(DateUseful date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initials=" + initials +
                ", balance=" + balance +
                ", user=" + user +
                ", transactions=" + transactions +
                '}';
    }
}
