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

    @Embedded

   private CreateInfo createInfo;

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

    public CreateInfo getCreateInfo() {
        return createInfo;
    }

    public Transaction setCreateInfo(CreateInfo createInfo) {
        this.createInfo = createInfo;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

}
