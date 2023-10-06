package it.repositoryImp;

import it.model.Company;
import it.repository.CompanyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImp implements CompanyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
    }

    @Override
    public void update(Company company, long id) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = session.get(Company.class, id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        session.merge(company1);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Company company = session.get(Company.class, id);
        session.delete(company);
    }

    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }
}
