package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityMoneySpentDTO;
import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityYearlyFundAllocationDTO;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;

import java.util.List;
import java.util.Optional;

public interface IUniversityYearlyFundAllocationRepository {
    public List<UniversityYearlyFundAllocation> findAllUniversitiesFunding();

    public List<UniversityYearlyFundAllocation> findAllUniversitiesFundingByYear(int year);

    public List<UniversityYearlyFundAllocation> findUniversityFundingForYear(int year, long universityId);
    public List<UniversityMoneySpentDTO>findUniverityAndTheMoneyTheirSpent(int year);
    public Optional<UniversityMoneySpentDTO> UniverityChecksHowMuchTheirSpentEachYear(int year,int universityID);

    public void save(UniversityYearlyFundAllocationDTO universityYearlyFundAllocationDTO);
}
