package co.za.ukukhulabursary.ukukhulabursary.service;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityAndApplicationDTO;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;

import java.util.List;
import java.util.Optional;

public interface IUniversityService {

    public List<Province> retrieveAllUniversityProvinces();

    public Province retrieveSingleUniversityProvince(long id);

    public List<University> retrieveAllUniversities();

    public University retrieveSingleUniversity(long universityId);

    public List<University> retrieveAllUniversitiesByStatusId(long statusId);

    public List<Status> retrieveAllStatuses();

    public void createUniversityAndApplication(UniversityAndApplicationDTO universityApplication);

    public List<UniversityYearlyFundAllocation> retrieveAllUniversityFundingUpToDate();

    public List<UniversityYearlyFundAllocation> retrieveAllUniversityFundingByYear(int year);

    public UniversityYearlyFundAllocation retrieveUniversityFundingForYear(int year, long universityId);
}