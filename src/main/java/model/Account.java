package model;

import enums.AccountType;

import javax.persistence.*;

@Entity
@Table(name="tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private Enum<AccountType> name;
    private String initials;
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login", referencedColumnName = "login", nullable = false, foreignKey = @ForeignKey(name = "fk_login"))
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

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
}
