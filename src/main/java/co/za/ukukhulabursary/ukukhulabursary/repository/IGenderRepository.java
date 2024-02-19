package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Gender;

import java.util.List;
import java.util.Optional;

public interface IGenderRepository {
    public Optional<Gender> findById(long id);

    public List<Gender> findAll();
}
