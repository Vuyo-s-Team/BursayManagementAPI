package co.za.ukukhulabursary.ukukhulabursary.service;

import co.za.ukukhulabursary.ukukhulabursary.model.Province;

import java.util.List;

public interface IUniversityService {

    public List<Province> retrieveAllUniversityProvinces();

    public Province retrieveSingleUniversityProvince(long id);
}
