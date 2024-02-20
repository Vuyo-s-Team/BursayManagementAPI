package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.exception.StatusNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.StudentApplicationNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.model.Program;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import co.za.ukukhulabursary.ukukhulabursary.model.Student;
import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.IProgramRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStatusRepository;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class StudentApplicationMapper implements RowMapper<StudentApplication> {
    private final IStudentRepository studentRepository;
    private final IStatusRepository statusRepository;
    private final IProgramRepository programRepository;
    @Override
    public StudentApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentApplication studentApplication = new StudentApplication();
        studentApplication.setApplicationID(rs.getLong("ApplicationID"));
        studentApplication.setYearOfStudies(rs.getInt("YearOfStudies"));
        studentApplication.setAverageGrade(rs.getDouble("AverageGrade"));
        studentApplication.setAmount(rs.getDouble("Amount"));
        studentApplication.setDateOfApplication(rs.getDate("DateOfApplication").toLocalDate());
        studentApplication.setComment(rs.getString("Comment"));
        long studentID = rs.getLong("StudentID");
        Student student = studentRepository.findById(studentID)
                .orElseThrow(()-> new StudentApplicationNotFoundException(String.valueOf(studentID)));
        studentApplication.setStudent(student);
        long programID= rs.getLong("ProgramID");
          Program program = programRepository.findById(programID)
                  .orElseThrow(()-> new StudentApplicationNotFoundException(String.valueOf(studentID)));
        studentApplication.setProgram(program);
        long statusId =rs.getLong("StatusID");
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new StatusNotFoundException(statusId));
        studentApplication.setStatus(status);
        return studentApplication;

    }
}
