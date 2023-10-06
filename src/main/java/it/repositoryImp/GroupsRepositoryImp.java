package it.repositoryImp;

import it.model.Company;
import it.model.Course;
import it.model.Groups;
import it.repository.GroupsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupsRepositoryImp implements GroupsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Groups groups) {
        Session session = sessionFactory.getCurrentSession();
        session.save(groups);
    }

    @Override
    public void update(Groups groups, long id) {
        Session session = sessionFactory.getCurrentSession();
        Groups groups1 = session.get(Groups.class, id);
        groups1.setGroupName(groups.getGroupName());
        groups1.setDateOfFinish(groups.getDateOfFinish());
        groups1.setDateOfStart(groups.getDateOfStart());
        session.merge(groups1);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Groups groups = session.get(Groups.class,id);
        session.delete(groups);
    }

    @Override
    public List<Groups> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select g from Groups g", Groups.class).getResultList();
    }

    @Override
    public Groups findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Groups.class,id);
    }
}
