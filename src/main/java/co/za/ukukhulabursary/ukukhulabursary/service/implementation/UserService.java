package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import co.za.ukukhulabursary.ukukhulabursary.exception.ContactNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import co.za.ukukhulabursary.ukukhulabursary.repository.IContactDetailsRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final IContactDetailsRepository contactRepository;

    @Override
    public List<ContactDetails> retrieveAllUserContacts() {
        return contactRepository.findAll();
    }

    @Override
    public ContactDetails retrieveSingleUserContact(long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
