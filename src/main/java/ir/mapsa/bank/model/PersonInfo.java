package ir.mapsa.bank.model;

import ir.mapsa.bank.model.enums.Language;
import ir.mapsa.bank.model.enums.Role;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Embeddable
public class PersonInfo {

    private String firstName;

    private String lastName;

    private String bio;

    private Language language;

    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private Role role;
@Embedded
    private CommunicativeInfo communicativeInfo;


    private String nationalId;

    public PersonInfo() {
    }

    public PersonInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public PersonInfo setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public PersonInfo setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public PersonInfo setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public PersonInfo setRole(Role role) {
        this.role = role;
        return this;
    }

    public CommunicativeInfo getCommunicativeInfo() {
        return communicativeInfo;
    }

    public PersonInfo setCommunicativeInfo(CommunicativeInfo communicativeInfo) {
        this.communicativeInfo = communicativeInfo;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public PersonInfo setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }
}
