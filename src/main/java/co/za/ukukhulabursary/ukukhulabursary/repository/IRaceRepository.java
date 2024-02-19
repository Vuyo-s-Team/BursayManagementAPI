package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Race;

import java.util.Optional;

public interface IRaceRepository {
    public Optional<Race> findById(long id);
}
