package it.repositoryImp;

import it.model.Teacher;
import it.repository.TeacherRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TeacherRepositoryImp implements TeacherRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public void update(Teacher teacher, long id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = session.get(Teacher.class, id);
        teacher1.setEmail(teacher.getEmail());
        teacher1.setFirstName(teacher1.getFirstName());
        teacher1.setLastName(teacher1.getLastName());
        session.merge(teacher1);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, id);
        session.delete(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select t from  Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Teacher findById(long id) {
        return null;
    }
}
