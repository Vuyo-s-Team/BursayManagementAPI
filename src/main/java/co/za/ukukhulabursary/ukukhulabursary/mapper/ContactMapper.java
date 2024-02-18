package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.Contact;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class ContactMapper implements RowMapper<Contact> {

@Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
    Contact contact = new Contact();
    if(rowNum > -1){
        contact.setId(rs.getLong("ContactID"));
        contact.setEmail(rs.getString("Email"));
        contact.setPhoneNumber(rs.getString("PhoneNumber"));
    }
    return contact;
}
}
