package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.exception.ContactDetailsNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;
import co.za.ukukhulabursary.ukukhulabursary.model.User;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.ContactDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


@Component
@AllArgsConstructor
public class UserMapper implements RowMapper<User> {

    private final ContactDetailsRepository contactDetailsRepository;
    @Override
    public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        User user = new User();
        if (rowNumber>0){
            user.setUserID(resultSet.getLong("UserID"));
            user.setFirstName(resultSet.getString("FirstName"));
            user.setLastName(resultSet.getString("LastName"));
            long contactID = resultSet.getLong("ContactID");
            ContactDetails contactDetails = contactDetailsRepository.findById(contactID)
                    .orElseThrow(() -> new ContactDetailsNotFoundException(contactID));
            user.setContactDetails(contactDetails);

        }
        return user;
    }
}
