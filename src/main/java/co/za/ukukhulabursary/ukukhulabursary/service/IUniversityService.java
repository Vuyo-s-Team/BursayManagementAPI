package co.za.ukukhulabursary.ukukhulabursary.service;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityAndApplicationDTO;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;

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
}