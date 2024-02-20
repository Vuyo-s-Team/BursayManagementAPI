package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Status;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    public List<T> findAll();

    public Optional<T> findById(long id);

}
