package it.repository;

import it.model.Company;
import it.model.Course;
import it.model.Groups;

import java.util.List;

public interface CourseRepository {
    void save(Course course);
    void update(Course course, long id);
    void delete(long id);
    List<Course> findAll();
    Course findById(long id);

}
