package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import java.util.List;
import java.util.Optional;

import co.za.ukukhulabursary.ukukhulabursary.exception.StudentApplicationNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UpdateStudentApplicationFailedException;
import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.StudentApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentApplicationService {
    private final StudentApplicationRepository studentApplicationRepository;

    public List<StudentApplication> getAllStudentApplications() {
        return studentApplicationRepository.getAllStudentApplications();
    }

    public Optional<StudentApplication> getStudentApplicationById(long ApplicationID) {
        return studentApplicationRepository.getStudentApplicationById(ApplicationID);          
    }
    
    public StudentApplication saveStudentApplication(StudentApplication StudentApplication) {
        return studentApplicationRepository.saveStudentApplication(StudentApplication);
    }

    public StudentApplication updateStudentApplication(StudentApplication updatedStudentApplication) {
        Long ApplicationID = updatedStudentApplication.getApplicationID();
        
        StudentApplication existingStudentApplication = studentApplicationRepository.getStudentApplicationById(ApplicationID)
            .orElseThrow(() -> new StudentApplicationNotFoundException("StudentApplication with ID " + ApplicationID + " not found"));

        existingStudentApplication.setYearOfStudies(updatedStudentApplication.getYearOfStudies());
        existingStudentApplication.setDateOfApplication(updatedStudentApplication.getDateOfApplication());
        existingStudentApplication.setAverageGrade(updatedStudentApplication.getAverageGrade());
        existingStudentApplication.setAmount(updatedStudentApplication.getAmount());
        existingStudentApplication.setComment(updatedStudentApplication.getComment());
        existingStudentApplication.setStudentID(updatedStudentApplication.getStudentID());
        existingStudentApplication.setProgramID(updatedStudentApplication.getProgramID());
        existingStudentApplication.setStatusID(updatedStudentApplication.getStatusID());

        return  studentApplicationRepository.updateStudentApplication(ApplicationID, existingStudentApplication)
            .orElseThrow(() -> new UpdateStudentApplicationFailedException("Failed to update StudentApplication with ID " + ApplicationID));

        }

    public String getApplicationStatusById(long applicationId) {
            return studentApplicationRepository.getApplicationStatusById(applicationId);
        }
}

