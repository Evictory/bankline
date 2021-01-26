package model;

import enums.TransactionType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_chart_of_account")
public class ChartOfAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String chartOfAccount;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private TransactionType type;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="chart_of_account_id")
    private List<Transaction> transactions;

    @Embedded
    private DateUseful date = new DateUseful();

    public ChartOfAccount() {}

    public ChartOfAccount(String chartOfAccount, TransactionType type, List<Transaction> transactions, DateUseful date) {
        this.chartOfAccount = chartOfAccount;
        this.type = type;
        this.transactions = transactions;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getChartOfAccount() {
        return chartOfAccount;
    }

    public void setChartOfAccount(String chartOfAccount) {
        this.chartOfAccount = chartOfAccount;
    }

    public Enum<TransactionType> getTransactionType() {
        return type;
    }

    public void setTransactionType(TransactionType type) {
        this.type = type;
    }

    public void addTransactions(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
        transactions.forEach(transaction -> transaction.setChartOfAccount(this));
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public DateUseful getDate() {
        return date;
    }

    public void setDate(DateUseful date) {
        this.date = date;
    }
}
