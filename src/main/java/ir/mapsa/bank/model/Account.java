package ir.mapsa.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "accountEntity")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer accountNumber;
    @ManyToOne(targetEntity = Branch.class)
    private Branch branch;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Customer> customers=new HashSet<>();


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transaction> transactions=new HashSet<>();

    @Version
    private Integer version;

    public Account() {
    }

    public Account(Integer accountNumber, Branch branch) {
        this.accountNumber = accountNumber;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }



    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Account setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Branch getBranch() {
        return branch;
    }

    public Account setBranch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Account setCustomers(Set<Customer> customers) {
        this.customers = customers;
        return this;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public Account setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public Integer getVersion() {
        return version;
    }


}
