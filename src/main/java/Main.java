import ir.mapsa.bank.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ir.mapsa.bank.utils.SessionFactoryProvider;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = SessionFactoryProvider.getSessionFactory();
        Session session = sf.openSession();

        session.getTransaction().begin();

        Bank bank = new Bank("new bank");
        Branch branch1 = new Branch(bank, "new branch code 11111");
        Branch branch2 = new Branch(bank, "new branch code 22222");
        Account account = new Account(146987, branch1);
        Customer customer = new Customer("new customer number");
        Transaction transaction = new Transaction(account, TransactionType.DEPOSIT);


        bank.getBranches().add(branch1);
        bank.getBranches().add(branch2);

        branch1.getAccounts().add(account);

        account.getCustomers().add(customer);


        account.getTransactions().add(transaction);

        customer.getAccounts().add(account);


        session.save(bank);
        session.save(account);
        session.save(branch1);
        session.save(branch2);
        session.save(customer);
        session.save(transaction);


        account.setAccountNumber(9856);

        session.update(account);


        session.getTransaction().commit();
        sf.close();

    }
}
