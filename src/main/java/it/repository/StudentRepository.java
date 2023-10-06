package it.repository;

import it.model.Company;
import it.model.Course;
import it.model.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);

    void update(Student student, long id);

    void delete(long id);

    List<Student> findAll();

    Student findById(long id);
}
