package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.ContactDetailsMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import co.za.ukukhulabursary.ukukhulabursary.repository.IContactDetailsRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class ContactDetailsRepository implements IRepository<ContactDetails> {

    private JdbcTemplate jdbcTemplate;
    private ContactDetailsMapper mapper;

    @Override
    public Optional<ContactDetails> findById(long id) {
        String sql = "SELECT * FROM [dbo].[ContactDetails] WHERE [ContactID] = ?";
        List<ContactDetails> contactDetails = jdbcTemplate.query(sql, mapper, id);
        if (!contactDetails.isEmpty()){
            return Optional.of(contactDetails.getFirst());
        }

        return Optional.empty();
    }

    public List<ContactDetails> findAll(){
        String sql = "SELECT * FROM [dbo].[ContactDetails]";
        return jdbcTemplate.query(sql, mapper);
    }
}
