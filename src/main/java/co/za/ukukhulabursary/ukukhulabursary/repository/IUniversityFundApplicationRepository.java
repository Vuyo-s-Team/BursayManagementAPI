package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.UniversityFundApplication;

import java.util.Optional;

public interface IUniversityFundApplicationRepository {

    public Optional<UniversityFundApplication> findByUniversityId(long universityId);
}
