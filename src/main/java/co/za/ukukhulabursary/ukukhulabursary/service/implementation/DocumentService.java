package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import java.util.List;
import java.util.Optional;

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
}
