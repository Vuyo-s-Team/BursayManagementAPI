package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentRepository {
    public List<Department> findAll();
    public Optional<Department> findById(long id);
}
