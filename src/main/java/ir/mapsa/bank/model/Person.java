package ir.mapsa.bank.model;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "DISK", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("PERSON_")
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Transient
    private Integer age;
    @Embedded
    private PersonInfo personInfo;
    @Version
    private Integer version;


    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public Person setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public Person setVersion(Integer version) {
        this.version = version;
        return this;
    }
}
