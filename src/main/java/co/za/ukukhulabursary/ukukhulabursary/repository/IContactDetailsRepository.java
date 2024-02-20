package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;

import java.util.List;
import java.util.Optional;

public interface IContactDetailsRepository {
    public Optional<ContactDetails> findById(long id);

    public List<ContactDetails> findAll();
}
