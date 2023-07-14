package ir.mapsa.bank.service;

import ir.mapsa.bank.model.CommunicativeInfo;
import ir.mapsa.bank.model.Customer;
import ir.mapsa.bank.model.PersonInfo;
import ir.mapsa.bank.model.enums.CommunicativeTypes;
import ir.mapsa.bank.model.enums.Language;
import ir.mapsa.bank.model.enums.Role;
import ir.mapsa.bank.repository.CustomerRepository;
import ir.mapsa.bank.utils.CustomerNumberGenerator;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CustomerService implements BaseService<Customer, String, Long> {

    private static CustomerService instance;

    private final CustomerRepository repository;


    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
            return instance;
        }
        return instance;
    }


    private CustomerService() {
        repository = CustomerRepository.getInstance();
    }


    @Override
    public void save(Customer customer) {
        repository.save(customer);

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public String getById(Long id) {
        return null;
    }

    @Override
    public String remove(Long id) {
        return null;
    }

    @Override
    public String remove(Customer customer) {
        return null;
    }

    @Override
    public List<String> getByExample(String example) {
        return null;
    }

    @Override
    public List<String> getAll() {
        return null;
    }

    public String createCustomer(String firstName,
                                 String lastName,
                                 String bio,
                                 String nationalId,
                                 LocalDate brithDay,
                                 Language language,
                                 String branchNumber,
                                 CommunicativeTypes communicativeTypes,
                                 String communicativeTypesPath) {

        Customer customer = new Customer();
        PersonInfo personInfo = new PersonInfo();
        CommunicativeInfo communicativeInfo = new CommunicativeInfo();


        customer.setCustomerNumber(CustomerNumberGenerator.customerNumberGenerator(branchNumber));
//        customer.setAccounts();
        customer.setAge(Math.abs(Period.between(brithDay, LocalDate.now()).getYears()));

        personInfo.setBio(bio);
        personInfo.setRole(Role.CUSTOMER);
        personInfo.setBirthDay(brithDay);
        personInfo.setLanguage(language);
        personInfo.setFirstName(firstName);
        personInfo.setLastName(lastName);
        personInfo.setNationalId(nationalId);


        communicativeInfo.setCommunicativeTypes(communicativeTypes);
        communicativeInfo.getCommunicativeTypesPaths().add(communicativeTypesPath);

        personInfo.setCommunicativeInfo(communicativeInfo);
        customer.setPersonInfo(personInfo);

        save(customer);
        return "customer saved successfully";
    }


    public static void main(String[] args) {
        CustomerService.getInstance().createCustomer(
                "yaser," ,
                "jamali",
                "the best",
                "123456789",
                LocalDate.of(1986,6,30),
                Language.ENGLISH,
                "1212",
                CommunicativeTypes.INSTAGRAM,
                "yaser.jamali@instagram");


    }
}
