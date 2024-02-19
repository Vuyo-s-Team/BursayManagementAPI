package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderMapper implements RowMapper<Gender> {
    @Override
    public Gender mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Gender gender = new Gender();
        if (rowNumber >-1){
            gender.setGenderID(resultSet.getLong("GenderID"));
            gender.setType(resultSet.getString("Type"));
        }
        return gender;
    }
}
