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
    private Enum<AccountType> initials;
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login", referencedColumnName = "login", nullable = false, foreignKey = @ForeignKey(name = "pk_login"))
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="account_id")
    private List<Transaction> transactions = new ArrayList<>();

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

    public void setInitials(Enum<AccountType> initials) {
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
}
