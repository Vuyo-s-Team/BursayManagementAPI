package co.za.ukukhulabursary.ukukhulabursary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.za.ukukhulabursary.ukukhulabursary.link.DocumentAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import co.za.ukukhulabursary.ukukhulabursary.service.implementation.DocumentService;


import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@RequestMapping("/document")
public class DocumentController {

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
