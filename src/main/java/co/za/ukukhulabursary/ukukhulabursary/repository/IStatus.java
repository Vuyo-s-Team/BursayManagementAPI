package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Status;

import java.util.List;
import java.util.Optional;

public interface IStatus {

    public List<Status> findAll();

    public Optional<Status> findById(long id);
}
