package ir.mapsa.bank.repository;

import ir.mapsa.bank.model.Bank;
import ir.mapsa.bank.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class BankRepository implements BaseRepository<Bank, String, Long> {

    private final SessionFactory sf;
    private final Session session;


    private static BankRepository instance;


    public static BankRepository getInstance() {
        if (instance == null) {
            instance = new BankRepository();
            return instance;
        }
        return instance;
    }


    private BankRepository() {
        sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    @Override
    public Bank save(Bank bank) {
        session.getTransaction().begin();
        session.save(bank);
        session.getTransaction().commit();
        return bank;
    }

    @Override
    public Bank update(Bank bank) {
        session.getTransaction().begin();
        session.update(bank);
        session.getTransaction().commit();
        return bank;
    }

    @Override
    public Bank getById(Long id) {
        Bank bank = session.find(Bank.class, id);

        return bank;
    }

    @Override
    public List<Bank> getByExample(String bankName) {

        String queryString = "SELECT b FROM bankEntity b WHERE b.bankName=:name";
        Query<Bank> query = session.createQuery(queryString, Bank.class);
        query.setParameter("name",bankName);
        List<Bank> BanksList = query.getResultList();
        return BanksList;
    }


    @Override
    public Bank remove(Long id) {
        Bank bank = session.find(Bank.class, id);
        if (bank != null) {
            session.remove(bank);
        }
        return bank;
    }

    @Override
    public Bank remove(Bank bank) {
        if (bank != null) {
            session.remove(bank);
        }
        return bank;
    }

    @Override
    public List<Bank> getAll() {
        sf.openSession();
        String queryString = "SELECT b FROM bankEntity b";
        Query<Bank> query = session.createQuery(queryString, Bank.class);
        List<Bank> BanksList = query.getResultList();
        return BanksList;
    }

    @Override
    public void close()  {
        sf.close();
        session.close();
    }
}
