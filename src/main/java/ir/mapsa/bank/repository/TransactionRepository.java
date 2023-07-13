package ir.mapsa.bank.repository;

import ir.mapsa.bank.model.Transaction;
import ir.mapsa.bank.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionRepository implements BaseRepository<Transaction, String, Long> {

    private final SessionFactory sf;
    private final Session session;


    private static TransactionRepository instance;


    public static TransactionRepository getInstance() {
        if (instance == null) {
            instance = new TransactionRepository();
            return instance;
        }
        return instance;
    }


    private TransactionRepository() {
        sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    @Override
    public Transaction save(Transaction transaction) {
        session.getTransaction().begin();
        session.save(transaction);
        session.getTransaction().commit();
        return transaction;
    }

    @Override
    public Transaction update(Transaction transaction) {
        session.getTransaction().begin();
        session.update(transaction);
        session.getTransaction().commit();
        return transaction;
    }

    @Override
    public Transaction getById(Long id) {
        Transaction transaction = session.find(Transaction.class, id);

        return transaction;
    }

    @Override
    public List<Transaction> getByExample(String type) {

        String queryString = "SELECT t FROM transactionEntity t WHERE t.transactionType=:ttype";
        Query<Transaction> query = session.createQuery(queryString, Transaction.class);
        query.setParameter("ttype",type);
        List<Transaction > transactionList = query.getResultList();
        return transactionList;
    }


    @Override
    public Transaction remove(Long id) {
        Transaction transaction = session.find(Transaction.class, id);
        if (transaction != null) {
            session.remove(transaction);
        }
        return transaction;
    }

    @Override
    public Transaction remove(Transaction transaction) {
        if (transaction != null) {
            session.remove(transaction);
        }
        return transaction;
    }

    @Override
    public List<Transaction> getAll() {
        String queryString = "SELECT t FROM transactionEntity t order by t.transactionType";
        Query<Transaction> query = session.createQuery(queryString, Transaction.class);
        List<Transaction> transactionList = query.getResultList();
        return transactionList;
    }

    @Override
    public void close()  {
        sf.close();
        session.close();
    }
}
