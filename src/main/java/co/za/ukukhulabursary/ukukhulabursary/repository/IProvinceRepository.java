package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Province;

import java.util.List;
import java.util.Optional;

public interface IProvinceRepository {
    public List<Province> findAll();

    public Optional<Province> findById(long id);
}
