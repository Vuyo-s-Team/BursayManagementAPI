package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentApplicationMapper implements RowMapper<StudentApplicationMapper> {
    @Override
    public StudentApplicationMapper mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        StudentApplication studentApplication = new StudentApplication();
        return  studentApplication;

    }
}
