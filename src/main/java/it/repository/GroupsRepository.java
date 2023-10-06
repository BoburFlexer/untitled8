package it.repository;

import it.model.Company;
import it.model.Course;
import it.model.Groups;

import java.util.List;

public interface GroupsRepository {
    void save(Groups groups);

    void update(Groups groups, long id);

    void delete(long id);

    List<Groups> findAll();

    Groups findById(long id);
}
