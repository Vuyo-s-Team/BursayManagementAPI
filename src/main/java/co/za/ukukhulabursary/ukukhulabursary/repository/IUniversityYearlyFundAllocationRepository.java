package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;

import java.time.LocalDate;
import java.util.List;

public interface IUniversityYearlyFundAllocationRepository {
    public List<UniversityYearlyFundAllocation> findAllUniversitiesFunding();

    public List<UniversityYearlyFundAllocation> findAllUniversitiesFundingByYear(int year);
}
