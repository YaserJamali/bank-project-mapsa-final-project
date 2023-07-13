package ir.mapsa.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String customerNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Account> accounts=new HashSet<>();


    @Version
    private Integer version;

    public Customer() {
    }

    public Customer(String customerNumber) {
        this.customerNumber = customerNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
