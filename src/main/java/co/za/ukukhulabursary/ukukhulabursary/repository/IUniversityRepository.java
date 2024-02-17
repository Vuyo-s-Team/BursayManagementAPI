package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.University;

import java.util.List;

public interface IUniversityRepository {

    public List<University> findAll();

    public List<University> findAllByStatusId(long statusId);
}
