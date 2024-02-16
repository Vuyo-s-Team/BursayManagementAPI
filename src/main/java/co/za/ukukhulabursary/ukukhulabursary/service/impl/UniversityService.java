package co.za.ukukhulabursary.ukukhulabursary.service.impl;

import co.za.ukukhulabursary.ukukhulabursary.exception.ProvinceNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.repository.IProvinceRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversityService implements IUniversityService {

    private final IProvinceRepository provinceRepository;

    @Override
    public List<Province> retrieveAllUniversityProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public Province retrieveSingleUniversityProvince(long id) {
        return provinceRepository.findById(id)
                .orElseThrow(() -> new ProvinceNotFoundException(id));
    }
}
