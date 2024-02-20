package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.za.ukukhulabursary.ukukhulabursary.mapper.StudentApplicationMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.IStudentApplicationRepository;

@Repository
public class StudentApplicationRepository implements IStudentApplicationRepository {

    private final JdbcTemplate jdbcTemplate;
    private final StudentApplicationMapper mapper;

    public StudentApplicationRepository(JdbcTemplate jdbcTemplate, StudentApplicationMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<StudentApplication>getAllStudentApplications() {
        String sql = "SELECT * FROM [dbo].[StudentApplication]";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Optional<StudentApplication> getStudentApplicationById(long applicationID) {
        String sql = "SELECT * FROM [dbo].[StudentApplication] WHERE [ApplicationID] = ?";
        List<StudentApplication> applications = jdbcTemplate.query(sql, mapper, applicationID);
        if (!applications.isEmpty()) {
            return Optional.of(applications.get(0));
        }
        return Optional.empty();
    }

    @Override
    public StudentApplication saveStudentApplication(StudentApplication studentApplication) {
        String sql = "INSERT INTO [dbo].[StudentApplication] (YearOfStudies, AverageGrade, Amount, DateOfApplication, Comment, StudentID, ProgramID, StatusID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, 
            studentApplication.getYearOfStudies(), 
            studentApplication.getAverageGrade(), 
            studentApplication.getAmount(), 
            studentApplication.getDateOfApplication(), 
            studentApplication.getComment(), 
            studentApplication.getStudentID(), 
            studentApplication.getProgramID(), 
            studentApplication.getStatusID()
        );
        return studentApplication;
    }

    @Override
    public Optional<StudentApplication> updateStudentApplication(long applicationID, StudentApplication updatedApplication) {
        String sql = "UPDATE [dbo].[StudentApplication] SET " +
                 "YearOfStudies = ?, " +
                 "AverageGrade = ?, " +
                 "Amount = ?, " +
                 "DateOfApplication = ?, " +
                 "Comment = ?, " +
                 "StudentID = ?, " +
                 "ProgramID = ?, " +
                 "StatusID = ? " +
                 "WHERE ApplicationID = ?";
    
        int rowsUpdated = jdbcTemplate.update(sql, 
            updatedApplication.getYearOfStudies(), 
            updatedApplication.getAverageGrade(), 
            updatedApplication.getAmount(), 
            updatedApplication.getDateOfApplication(), 
            updatedApplication.getComment(), 
            updatedApplication.getStudentID(), 
            updatedApplication.getProgramID(), 
            updatedApplication.getStatusID(), 
            applicationID
        );
    
        if (rowsUpdated > 0) {
            return Optional.of(updatedApplication);
        } else {
            return Optional.empty();
        }
    }

     @Override
     public String getApplicationStatusById(long applicationId) {
        String sql = "SELECT s.Type " +
                     "FROM Status s " +
                     "INNER JOIN StudentApplication sa ON sa.StatusID = s.StatusID " +
                     "WHERE sa.ApplicationID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, applicationId);
        } catch (EmptyResultDataAccessException e) {
            return "Status not found";
        }
    }
    
}
