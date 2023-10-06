package it.repositoryImp;

import it.model.Student;
import it.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentRepositoryImp implements StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void update(Student student, long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = session.get(Student.class,id);
        student1.setEmail(student.getEmail());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        session.merge(student1);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class,id);
        session.delete(student);
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select s from Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class,id);
    }
}
