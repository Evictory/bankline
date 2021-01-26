package model;

import enums.TransactionType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tb_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="chart_of_account_id")
    private ChartOfAccount chartOfAccount;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_type")
    private Enum<TransactionType> transactionType;

    @Column(name="account_destination")
    private String accountDestination;
    private Double value;
    private String description;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ChartOfAccount getChartOfAccount() {
        return chartOfAccount;
    }

    public void setChartOfAccount(ChartOfAccount chartOfAccount) {
        this.chartOfAccount = chartOfAccount;
    }

    public Enum<TransactionType> getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Enum<TransactionType> transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(String accountDestination) {
        this.accountDestination = accountDestination;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
