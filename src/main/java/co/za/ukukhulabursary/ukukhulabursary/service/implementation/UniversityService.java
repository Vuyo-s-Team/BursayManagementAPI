package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityAndApplicationDTO;
import co.za.ukukhulabursary.ukukhulabursary.exception.ProvinceNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.repository.IProvinceRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStatusRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IUniversityRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversityService implements IUniversityService {

    private final IProvinceRepository provinceRepository;
    private final IUniversityRepository universityRepository;
    private final IStatusRepository statusRepository;

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
}
