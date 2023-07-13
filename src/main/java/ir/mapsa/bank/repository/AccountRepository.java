package ir.mapsa.bank.repository;

import ir.mapsa.bank.model.Account;
import ir.mapsa.bank.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository implements BaseRepository<Account, String, Long> {

    private final SessionFactory sf;
    private final Session session;


    private static AccountRepository instance;


    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
            return instance;
        }
        return instance;
    }


    private AccountRepository() {
        sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    @Override
    public Account save(Account account) {
        session.getTransaction().begin();
        session.save(account);
        session.getTransaction().commit();
        return account;
    }

    @Override
    public Account update(Account account) {
        session.getTransaction().begin();
        session.update(account);
        session.getTransaction().commit();
        return account;
    }

    @Override
    public Account getById(Long id) {
        Account account = session.find(Account.class, id);

        return account;
    }

    @Override
    public List<Account> getByExample(String bankName) {

//        String queryString = "SELECT a FROM accountEntity a WHERE a.=:name";
//        Query<Bank> query = session.createQuery(queryString, Bank.class);
//        query.setParameter("name",bankName);
//        List<Bank> BanksList = query.getResultList();
//        return BanksList;
        return null;
    }



    @Override
    public Account remove(Long id) {
        Account account = session.find(Account.class, id);
        if (account != null) {
            session.remove(account);
        }
        return account;
    }

    @Override
    public Account remove(Account account) {
        if (account != null) {
            session.remove(account);
        }
        return account;
    }

    @Override
    public List<Account> getAll() {
        sf.openSession();
        String queryString = "SELECT a FROM accountEntity a";
        Query<Account> query = session.createQuery(queryString, Account.class);
        List<Account> accountList = query.getResultList();
        return accountList;
    }

    public Account getAl() {
        sf.openSession();
        String queryString = "SELECT a FROM accountEntity a";
        Query<Account> query = session.createQuery(queryString, Account.class);
        Account account = query.getSingleResult();
        return account;
    }

    public static void main(String[] args) {
        AccountRepository repository=AccountRepository.getInstance();
        System.out.println(repository.getAl().getAccountNumber());
    }

    @Override
    public void close() {
        sf.close();
        session.close();
    }
}
