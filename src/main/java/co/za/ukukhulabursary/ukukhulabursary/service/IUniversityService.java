package co.za.ukukhulabursary.ukukhulabursary.service;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityAndApplicationDTO;
import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityYearlyFundAllocationDTO;
import co.za.ukukhulabursary.ukukhulabursary.model.*;

import java.util.List;

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

    public List<UniversityYearlyFundAllocation> retrieveUniversityFundingForYear(int year, long universityId);

    public UniversityFundApplication updateUniversityApplicationStatus(long universityId, long statusId);

    public void allocateUniversityFunding(UniversityYearlyFundAllocationDTO universityYearlyFundAllocationDTO);
}