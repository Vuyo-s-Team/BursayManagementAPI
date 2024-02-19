package co.za.ukukhulabursary.ukukhulabursary.repository;

import java.util.List;
import java.util.Optional;

import co.za.ukukhulabursary.ukukhulabursary.model.Document;

public interface IStudentApplicationRepository {
     List<Document> getAllStudentApplication();

    Optional<Document> getStudentApplicationById(long DocumentID);
    
    Document saveStudentApplication(Document document);

    Optional<Document> updateStudentApplication(long documentID, Document updatedDocument);
}
