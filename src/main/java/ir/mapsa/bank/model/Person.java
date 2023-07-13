package ir.mapsa.bank.model;

import javax.persistence.Version;

public class Person {
    private String firstName;
    private String lastName;

    private String nationalId;

    @Version
    private Integer version;


}
