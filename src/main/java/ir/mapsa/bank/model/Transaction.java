package ir.mapsa.bank.model;


import ir.mapsa.bank.model.enums.TransactionType;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "transactionEntity")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Account account;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Version
    private Integer version;

    public Transaction() {
    }

    public Transaction(Account account, TransactionType transactionType) {
        this.account = account;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Transaction setAccount(Account account) {
        this.account = account;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Transaction setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Transaction setDate(Date date) {
        this.date = date;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

}
