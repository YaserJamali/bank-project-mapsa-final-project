package ir.mapsa.bank.repository;

import ir.mapsa.bank.model.Customer;
import ir.mapsa.bank.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerRepository implements BaseRepository<Customer, String, Long> {

    private final SessionFactory sf;
    private final Session session;


    private static CustomerRepository instance;


    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
            return instance;
        }
        return instance;
    }


    private CustomerRepository() {
        sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    @Override
    public Customer save(Customer customer) {
        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        session.getTransaction().begin();
        session.update(customer);
        session.getTransaction().commit();
        return customer;
    }

    @Override
    public Customer getById(Long id) {
        Customer customer = session.find(Customer.class, id);

        return customer;
    }

    @Override
    public List<Customer> getByExample(String example) {

        String queryString = "SELECT c FROM customerEntity c WHERE c.customerNumber=:codeNumber";
        Query<Customer> query = session.createQuery(queryString, Customer.class);
        query.setParameter("codeNumber",example);
        List<Customer> customersList = query.getResultList();
        return customersList;
    }

    public static void main(String[] args) {
        CustomerRepository repository=CustomerRepository.getInstance();
//        System.out.println(repository.getAll());
        System.out.println(repository.getById(6L).getCustomerNumber());
        System.out.println();
        repository.getByExample("1002BR20000").forEach(i -> System.out.println(i.getId()));

    }

    @Override
    public Customer remove(Long id) {
        Customer customer = session.find(Customer.class, id);
        if (customer != null) {
            session.remove(customer);
        }
        return customer;
    }

    @Override
    public Customer remove(Customer customer) {
        if (customer != null) {
            session.remove(customer);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        sf.openSession();
        String queryString = "SELECT C FROM customerEntity C";
        Query<Customer> query = session.createQuery(queryString, Customer.class);
        List<Customer> customersList = query.getResultList();
        return customersList;
    }

    @Override
    public void close()  {
        sf.close();
        session.close();
    }
}
