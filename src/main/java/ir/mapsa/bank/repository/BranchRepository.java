package ir.mapsa.bank.repository;

import ir.mapsa.bank.model.Branch;
import ir.mapsa.bank.utils.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class BranchRepository implements BaseRepository<Branch, String, Long> {

    private final SessionFactory sf;
    private final Session session;


    private static BranchRepository instance;


    public static BranchRepository getInstance() {
        if (instance == null) {
            instance = new BranchRepository();
            return instance;
        }
        return instance;
    }


    private BranchRepository() {
        sf = SessionFactoryProvider.getSessionFactory();
        session = sf.openSession();
    }


    @Override
    public Branch save(Branch branch) {
        session.getTransaction().begin();
        session.save(branch);
        session.getTransaction().commit();
        return branch;
    }

    @Override
    public Branch update(Branch branch) {
        session.getTransaction().begin();
        session.update(branch);
        session.getTransaction().commit();
        return branch;
    }

    @Override
    public Branch getById(Long id) {
        Branch branch = session.find(Branch.class, id);

        return branch;
    }

    @Override
    public List<Branch> getByExample(String branchCode) {

        String queryString = "SELECT b FROM branchEntity b WHERE b.branchCode=:code";
        Query<Branch> query = session.createQuery(queryString, Branch.class);
        query.setParameter("code",branchCode);
        List<Branch > branchList = query.getResultList();
        return branchList;
    }



    @Override
    public Branch remove(Long id) {
        Branch branch = session.find(Branch.class, id);
        if (branch != null) {
            session.remove(branch);
        }
        return branch;
    }

    @Override
    public Branch remove(Branch branch) {
        if (branch != null) {
            session.remove(branch);
        }
        return branch;
    }

    @Override
    public List<Branch> getAll() {
        sf.openSession();
        String queryString = "SELECT b FROM branchEntity b";
        Query<Branch> query = session.createQuery(queryString, Branch.class);
        List<Branch> branchList = query.getResultList();
        return branchList;
    }

    @Override
    public void close()  {
        sf.close();
        session.close();
    }
}
