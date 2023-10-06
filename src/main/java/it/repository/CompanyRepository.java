package it.repository;

import it.model.Company;

import java.util.List;

public interface CompanyRepository {
    void save(Company company);
    void update(Company company, long id);
    void delete(long id);
    List<Company> findAll();
    Company findById(long id);

}
