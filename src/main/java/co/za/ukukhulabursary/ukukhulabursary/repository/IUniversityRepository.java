package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.University;

import java.util.List;
import java.util.Optional;

public interface IUniversityRepository {

    public List<University> findAll();

    public List<University> findAllByStatusId(long statusId);

    public Optional<University> findById(long id);
}
