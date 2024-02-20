package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import java.util.List;
import java.util.Optional;

import co.za.ukukhulabursary.ukukhulabursary.exception.StudentApplicationNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UpdateStudentApplicationFailedException;
import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.StudentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentApplicationService {
    private final StudentApplicationRepository studentApplicationRepository;

    @Autowired
    public StudentApplicationService(StudentApplicationRepository StudentApplicationRepository) {
        studentApplicationRepository = StudentApplicationRepository;
    }

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
        existingStudentApplication.setStudent(updatedStudentApplication.getStudent());
        existingStudentApplication.setProgram(updatedStudentApplication.getProgram());
        existingStudentApplication.setStatus(updatedStudentApplication.getStatus());

        return  studentApplicationRepository.updateStudentApplication(ApplicationID, existingStudentApplication)
            .orElseThrow(() -> new UpdateStudentApplicationFailedException("Failed to update StudentApplication with ID " + ApplicationID));
        
    }
}

