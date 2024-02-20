package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import co.za.ukukhulabursary.ukukhulabursary.exception.ContactNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import co.za.ukukhulabursary.ukukhulabursary.model.User;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.ContactDetailsRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UserRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final ContactDetailsRepository contactRepository;
    private final UserRepository userRepositoryRepository;



    @Override
    public List<ContactDetails> retrieveAllUserContacts() {
        return contactRepository.findAll();
    }

    @Override
    public ContactDetails retrieveSingleUserContact(long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepositoryRepository.findAll();
    }


}
