package co.za.ukukhulabursary.ukukhulabursary.repository.implementation;

import co.za.ukukhulabursary.ukukhulabursary.mapper.DocumentMapper;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.repository.IDocumentRepository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class DocumentRepository implements  IDocumentRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DocumentMapper mapper;

    @Override
    public List<Document> getAllDocuments() {
        String sql = "SELECT * FROM [dbo].[Document]";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Document saveDocument(Document document) {
        String sql = "INSERT INTO [dbo].[Document] (Transcript, IdentityDocument, ApplicationID) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, document.getTranscript(), document.getIdentityDocument(), document.getApplicationID());
        return document;
    }

}
