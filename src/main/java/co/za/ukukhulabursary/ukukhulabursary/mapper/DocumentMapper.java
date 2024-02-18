package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DocumentMapper implements RowMapper<Document> {

    @Override
    public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
        Document document = new Document();
        document.setDocumentID(rs.getLong("id"));
        document.setTranscript(rs.getString("transcript"));
        document.setIdentityDocument(rs.getString("identityDocument"));
        document.setApplicationID(rs.getInt("applicationID"));
        return document;
    }
}

