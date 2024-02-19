package co.za.ukukhulabursary.ukukhulabursary.repository;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;

import java.util.List;
import java.util.Optional;


public interface IDocumentRepository {

    List<Document> getAllDocuments();

    Optional<Document> getDocumentById(long DocumentID);
    
    Document saveDocument(Document document);

    Optional<Document> updateDocument(long documentID, Document updatedDocument);


}
