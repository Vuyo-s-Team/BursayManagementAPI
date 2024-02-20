package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ContactDetailsMapper  implements RowMapper<ContactDetails> {
    @Override
    public ContactDetails mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        ContactDetails contactDetails = new ContactDetails();
        if (rowNumber > -1) {
            contactDetails.setId(resultSet.getLong("ContactID"));
            contactDetails.setEmail(resultSet.getString("Email"));
            contactDetails.setPhoneNumber(resultSet.getString("PhoneNumber"));

        }
        return contactDetails;
    }
}
