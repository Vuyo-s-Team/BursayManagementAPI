package co.za.ukukhulabursary.ukukhulabursary.repository;

import java.util.List;
import java.util.Optional;

import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;

public interface IStudentApplicationRepository {
    List<StudentApplication> getAllStudentApplications();

    Optional<StudentApplication> getStudentApplicationById(long ApplicationID);
    
    StudentApplication saveStudentApplication(StudentApplication document);

    Optional<StudentApplication> updateStudentApplication(long ApplicationID, StudentApplication updatedApplication);

    String getApplicationStatusById(long applicationId);
}
