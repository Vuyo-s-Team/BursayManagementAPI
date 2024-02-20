package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.DocumentMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import co.za.ukukhulabursary.ukukhulabursary.repository.IDocumentRepository;

import co.za.ukukhulabursary.ukukhulabursary.repository.IRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class DocumentRepository implements IRepository<Document> {

    private final JdbcTemplate jdbcTemplate;
    private final DocumentMapper mapper;


    public List<Document> getAllDocuments() {
        String sql = "SELECT * FROM [dbo].[Document]";
        return jdbcTemplate.query(sql, mapper);
    }


    public Optional<Document> getDocumentById(long DocumentID) {
        String sql = "SELECT * FROM [dbo].[Document] WHERE [DocumentID] = ?";
        List<Document> Document = jdbcTemplate.query(sql, mapper,DocumentID);
        if (!Document.isEmpty())
            return Optional.of(Document.getFirst());
        return Optional.empty();
    }


    public Document saveDocument(Document document) {
        String sql = "INSERT INTO [dbo].[Document] (Transcript, IdentityDocument, ApplicationID) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, document.getTranscript(), document.getIdentityDocument(), document.getApplicationID());
        return document;
    }


    public Optional<Document> updateDocument(long documentID, Document updatedDocument) {
        String sql = "UPDATE [dbo].[Document] SET Transcript = ?, IdentityDocument = ?, ApplicationID = ? WHERE DocumentID = ?";
        
        int rowsUpdated = jdbcTemplate.update(sql, 
                updatedDocument.getTranscript(), 
                updatedDocument.getIdentityDocument(), 
                updatedDocument.getApplicationID(), 
                documentID);
        
        if (rowsUpdated > 0) {
            return Optional.of(updatedDocument);
        } else {
            return Optional.empty();
        }
    }


    @Override
    public List<Document> findAll() {
        return null;
    }

    @Override
    public Optional<Document> findById(long id) {
        return Optional.empty();
    }
}
