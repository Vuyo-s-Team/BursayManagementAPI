package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import co.za.ukukhulabursary.ukukhulabursary.exception.ContactNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.ProvinceNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.Contact;
import co.za.ukukhulabursary.ukukhulabursary.repository.IContactRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final IContactRepository contactRepository;

    @Override
    public List<Contact> retrieveAllUserContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact retrieveSingleUserContact(long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
