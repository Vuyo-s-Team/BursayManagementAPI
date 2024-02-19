package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactRepository {
    public List<Contact> findAll();
    public Optional<Contact> findById(long id);
}
