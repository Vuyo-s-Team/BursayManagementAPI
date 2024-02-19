package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import java.util.List;
import java.util.Optional;

import co.za.ukukhulabursary.ukukhulabursary.exception.DocumentNotFoundException;
import co.za.ukukhulabursary.ukukhulabursary.exception.UpdateDocumentFailedException;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.getAllDocuments();
    }

    public  Optional<Document> getDocumentById(long DocumentID){
        return documentRepository.getDocumentById(DocumentID);

    }

    public Document saveDocument(Document document) {
        return documentRepository.saveDocument(document);
    }

    public Document updateDocument(Document updatedDocument) {
        Long documentID = updatedDocument.getDocumentID();
        
        Optional<Document> existingDocumentOptional = documentRepository.getDocumentById(documentID);
        
        if (existingDocumentOptional.isPresent()) {
            Document existingDocument = existingDocumentOptional.get();
            existingDocument.setTranscript(updatedDocument.getTranscript());
            existingDocument.setIdentityDocument(updatedDocument.getIdentityDocument());
            existingDocument.setApplicationID(updatedDocument.getApplicationID());
    
            Optional<Document> updatedDocumentOptional = documentRepository.updateDocument(documentID, existingDocument);
            if (updatedDocumentOptional.isPresent()) {
                return updatedDocumentOptional.get();
            } else {
                throw new UpdateDocumentFailedException("Failed to update document with ID " + documentID);
            }
        } else {
            throw new DocumentNotFoundException("Document with ID " + documentID + " not found");
        }
    }
    

}
