package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityAndApplicationDTO;
import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityYearlyFundAllocationDTO;
import co.za.ukukhulabursary.ukukhulabursary.exception.ProvinceNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityFundApplicationNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.*;
import co.za.ukukhulabursary.ukukhulabursary.repository.*;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.ProvinceRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UniversityFundApplicationRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UniversityRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UniversityYearlyFundAllocationRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversityService implements IUniversityService {

    private final ProvinceRepository provinceRepository;
    private final UniversityRepository universityRepository;
    private final IRepository<Status> statusRepository;
    private final UniversityYearlyFundAllocationRepository universityYearlyFundAllocationRepository;
    private final UniversityFundApplicationRepository universityFundApplicationRepository;


    @Override
    public List<Province> retrieveAllUniversityProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public Province retrieveSingleUniversityProvince(long id) {
        return provinceRepository.findById(id)
                .orElseThrow(() -> new ProvinceNotFoundException(id));
    }

    @Override
    public List<University> retrieveAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University retrieveSingleUniversity(long universityId) {
        return universityRepository.findById(universityId)
                .orElseThrow(() -> new UniversityNotFoundException(universityId));
    }

    @Override
    public List<University> retrieveAllUniversitiesByStatusId(long statusId) {
        return universityRepository.findAllByStatusId(statusId);
    }

    @Override
    public List<Status> retrieveAllStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public void createUniversityAndApplication(UniversityAndApplicationDTO universityApplication) {
        universityRepository.save(universityApplication);
    }

    @Override
    public List<UniversityYearlyFundAllocation> retrieveAllUniversityFundingUpToDate() {
        return universityYearlyFundAllocationRepository.findAllUniversitiesFunding();
    }

    @Override
    public List<UniversityYearlyFundAllocation> retrieveAllUniversityFundingByYear(int year) {
        return universityYearlyFundAllocationRepository.findAllUniversitiesFundingByYear(year);
    }

    @Override
    public List<UniversityYearlyFundAllocation> retrieveUniversityFundingForYear(int year, long universityId) {
        return universityYearlyFundAllocationRepository.findUniversityFundingForYear(year, universityId);
    }

    @Override
    public UniversityFundApplication updateUniversityApplicationStatus(long universityId, long statusId) {
        return universityFundApplicationRepository.updateUniversityApplicationStatus(universityId, statusId)
                .orElseThrow(() -> new UniversityFundApplicationNotFoundException(universityId));
    }

    @Override
    public void allocateUniversityFunding(
            UniversityYearlyFundAllocationDTO universityYearlyFundAllocationDTO) {
        universityYearlyFundAllocationRepository.save(universityYearlyFundAllocationDTO);
    }
}
