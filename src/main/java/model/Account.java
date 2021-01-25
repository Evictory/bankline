package model;

import enums.AccountType;

import javax.persistence.*;

@Entity
@Table(name="tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Enum<AccountType> initials;
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login", referencedColumnName = "login", nullable = false, foreignKey = @ForeignKey(name = "fk_login"))
    private User user;

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
}
