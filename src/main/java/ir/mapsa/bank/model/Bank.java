package ir.mapsa.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity(name="bankEntity")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String bankName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Branch> branches=new HashSet<>();


    @Version
    private Integer version;

    public Bank() {
    }

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Long getId() {
        return id;
    }


    public String getBankName() {
        return bankName;
    }

    public Bank setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public Bank setBranches(Set<Branch> branches) {
        this.branches = branches;
        return this;
    }

    public Integer getVersion() {
        return version;
    }


}
