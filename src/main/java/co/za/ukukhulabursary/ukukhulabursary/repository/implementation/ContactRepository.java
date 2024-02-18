package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.ContactMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Contact;
import co.za.ukukhulabursary.ukukhulabursary.repository.IContact;
import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.module.FindException;
import java.util.List;

@AllArgsConstructor
@Repository
public class ContactRepository implements IContact {
    private final JdbcTemplate jdbcTemplate;
    private final ContactMapper mapper;
    @Override
    public List<Contact> findAll(){
        String sql = "SELECT * FROM [dbo].[Contact]";
        List<Contact> contacts = jdbcTemplate.query(sql, mapper);
        return contacts;
    }

    @Override
    public Contact findById() {
        return null;
    }
}
