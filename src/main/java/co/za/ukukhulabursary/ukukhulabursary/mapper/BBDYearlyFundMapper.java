package co.za.ukukhulabursary.ukukhulabursary.mapper;

import co.za.ukukhulabursary.ukukhulabursary.link.DocumentAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.BBDYearlyFund;

import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import co.za.ukukhulabursary.ukukhulabursary.service.implementation.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BBDYearlyFundMapper implements RowMapper<BBDYearlyFund> {

    @Override
    public  BBDYearlyFund mapRow(ResultSet resultSet , int rowNumber)throws SQLException{
        BBDYearlyFund bbdYearlyFund = new BBDYearlyFund();
        if(rowNumber>0){
            bbdYearlyFund.setYearlyFundID(resultSet.getLong("YearlyFundID"));
            bbdYearlyFund.setTotalAmount(resultSet.getDouble("TotalAmount"));
            bbdYearlyFund.setRemainingAmount(resultSet.getDouble("tRemainingAmount"));
            bbdYearlyFund.setFinacialYearStart(resultSet.getDate("FinancialYearStart"));
            bbdYearlyFund.setStudentFundCap(resultSet.getDouble("StudentFundCap"));
        }


        return  bbdYearlyFund;

    }

    @RestController
    @RequestMapping("api/v1/document")
    public static class DocumentController {

        private final DocumentService documentService;
       private final DocumentAssembler documentAssembler;

        @Autowired
        public DocumentController(DocumentService documentService, DocumentAssembler documentAssembler) {
            this.documentService = documentService;
            this.documentAssembler = documentAssembler;
        }

        @GetMapping("")
        public ResponseEntity<List<EntityModel<Document>>> getAllDocuments() {
            List<Document> documents = documentService.getAllDocuments();
            List<EntityModel<Document>> entityModels = documents.stream()
                    .map(documentAssembler::toModel)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(entityModels);
        }

        @PostMapping("")
        public ResponseEntity<EntityModel<Document>> saveDocument(@RequestBody Document document) {
             documentService.saveDocument(document);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
            Optional<Document> optionalDocument = documentService.getDocumentById(id);
            return optionalDocument
                    .map(document -> ResponseEntity.ok(document))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Document> updateDocument(@PathVariable int id, @RequestBody Document updatedDocument) {
            try {
                Optional<Document> optionalExistingDocument = documentService.getDocumentById(id);

                if (optionalExistingDocument.isPresent()) {
                    Document existingDocument = optionalExistingDocument.get();
                    existingDocument.setTranscript(updatedDocument.getTranscript());
                    existingDocument.setIdentityDocument(updatedDocument.getIdentityDocument());
                    existingDocument.setApplicationID(updatedDocument.getApplicationID());
                    Document updated = documentService.updateDocument(existingDocument);
                    return ResponseEntity.ok(updated);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

    }
}
