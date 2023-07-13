package ir.mapsa.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "branchEntity")

public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    @ManyToOne(targetEntity = Bank.class)
    private Bank bank;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Account> accounts=new HashSet<>();
    private String branchCode;

    @Version
    private Integer version;

    public Branch() {
    }

    public Branch(Bank bank,  String branchCode) {
        this.bank = bank;
        this.branchCode = branchCode;
    }

    public Long getId() {
        return id;
    }


    public Bank getBank() {
        return bank;
    }

    public Branch setBank(Bank bank) {
        this.bank = bank;
        return this;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public Branch setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
        return this;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public Branch setBranchCode(String branchCode) {
        this.branchCode = branchCode;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

}
