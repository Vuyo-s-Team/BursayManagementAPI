package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.ContactMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Contact;
import co.za.ukukhulabursary.ukukhulabursary.repository.IContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class ContactRepository implements IContactRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ContactMapper mapper;
    @Override
    public List<Contact> findAll(){
        String sql = "SELECT * FROM [dbo].[Contact]";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Optional<Contact> findById(long id) {
        String sql = "SELECT * FROM [dbo].[Contact] WHERE ContactID=?";
        List<Contact> contacts = jdbcTemplate.query(sql,mapper,id);
        if (!contacts.isEmpty())
            return Optional.of(contacts.getFirst());
        return Optional.empty();
    }
}
