package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Program;
import java.util.Optional;

public interface IProgramRepository {

    public Optional<Program> findById(long id);
}
