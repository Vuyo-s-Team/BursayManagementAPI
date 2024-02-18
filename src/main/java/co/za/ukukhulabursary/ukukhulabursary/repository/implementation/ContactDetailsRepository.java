package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.ContactDetailsMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class ContactDetailsRepository  {

    private JdbcTemplate jdbcTemplate;
    private ContactDetailsMapper mapper;


    public Optional<ContactDetails> findById(long id) {
        String sql = "SELECT * FROM [dbo].[ContactDetails] WHERE [ContactID] = ?";
        List<ContactDetails> contactDetails = jdbcTemplate.query(sql, mapper, id);
        if (!contactDetails.isEmpty()){
            return Optional.of(contactDetails.getFirst());
        }

        return Optional.empty();
    }
}
