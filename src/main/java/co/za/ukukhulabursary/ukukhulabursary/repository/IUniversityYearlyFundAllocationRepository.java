package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IUniversityYearlyFundAllocationRepository {
    public List<UniversityYearlyFundAllocation> findAllUniversitiesFunding();

    public List<UniversityYearlyFundAllocation> findAllUniversitiesFundingByYear(int year);

    public Optional<UniversityYearlyFundAllocation> findUniversityFundingForYear(int year, long universityId);
}
