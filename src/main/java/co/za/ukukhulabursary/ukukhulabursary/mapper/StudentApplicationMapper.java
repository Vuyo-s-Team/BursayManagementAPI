package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentApplicationMapper implements RowMapper<StudentApplication> {

    @Override
    public StudentApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentApplication studentApplication = new StudentApplication();
        studentApplication.setApplicationID(rs.getLong("ApplicationID"));
        studentApplication.setYearOfStudies(rs.getInt("YearOfStudies"));
        studentApplication.setAverageGrade(rs.getDouble("AverageGrade"));
        studentApplication.setAmount(rs.getDouble("Amount"));
        studentApplication.setDateOfApplication(rs.getDate("DateOfApplication").toLocalDate());
        studentApplication.setComment(rs.getString("Comment"));
        studentApplication.setStudentID(rs.getInt("StudentID"));
        studentApplication.setProgramID(rs.getInt("ProgramID"));
        studentApplication.setStatusID(rs.getInt("StatusID"));
        return studentApplication;
    }
}
