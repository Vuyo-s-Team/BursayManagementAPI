package co.za.ukukhulabursary.ukukhulabursary.service.implementation;

import java.util.List;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.DocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentService{
    private DocumentRepository DocumentRepository;
    public List<Document> getAllDocuments(){
        return DocumentRepository.getAllDocuments();
    }
}