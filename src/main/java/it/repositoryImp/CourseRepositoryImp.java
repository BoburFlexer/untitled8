package it.repositoryImp;

import it.model.Course;
import it.model.Groups;
import it.repository.CourseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepositoryImp implements CourseRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void update(Course course, long id) {
        Session session = sessionFactory.getCurrentSession();
        Course course1 = session.get(Course.class, id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        session.merge(course1);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class,id);
        session.delete(course);
    }

    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class,id);
    }
}