package co.za.ukukhulabursary.ukukhulabursary.service;



import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import co.za.ukukhulabursary.ukukhulabursary.model.User;

import java.util.List;

public interface IUserService {

    public List<ContactDetails> retrieveAllUserContacts();

    public ContactDetails retrieveSingleUserContact(long id);

    public List<User> retrieveAllUsers();
}
