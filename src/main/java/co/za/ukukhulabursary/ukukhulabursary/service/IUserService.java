package co.za.ukukhulabursary.ukukhulabursary.service;



import co.za.ukukhulabursary.ukukhulabursary.model.Contact;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<Contact> retrieveAllUserContacts();

    public Contact retrieveSingleUserContact(long id);
}
