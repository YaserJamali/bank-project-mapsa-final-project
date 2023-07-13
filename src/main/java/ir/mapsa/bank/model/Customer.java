package ir.mapsa.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "customerEntity")
@Table(name ="CUSTOMER" )
@DiscriminatorValue("CUSTOMER")
public class Customer extends Person{


    private String customerNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Account> accounts=new HashSet<>();


    public Customer() {
    }

    public Customer(String customerNumber) {
        this.customerNumber = customerNumber;
    }


    public String getCustomerNumber() {
        return customerNumber;
    }

    public Customer setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        return this;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public Customer setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
        return this;
    }
}

