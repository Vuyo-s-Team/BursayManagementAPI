package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.model.User;

import java.util.List;
import java.util.Optional;


public interface IUserRepository {

    public List<User> findAll();
    public Optional<User> findById(long id);
}
