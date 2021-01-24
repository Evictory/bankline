package model;

import enums.AccountType;

import javax.persistence.*;

@Entity
@Table(name="tb_account")
public class Account {

    @Id
    private int id;
    private Enum<AccountType> name;
    private String initials;
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Enum<AccountType> getName() {
        return name;
    }

    public void setName(Enum<AccountType> name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
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
