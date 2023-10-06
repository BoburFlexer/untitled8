package it.repository;

import it.model.Teacher;

import java.util.List;

public interface TeacherRepository {
    void save(Teacher teacher);

    void update(Teacher teacher, long id);

    void delete(long id);

    List<Teacher> findAll();

    Teacher findById(long id);
}
