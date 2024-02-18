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

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;
   private final DocumentAssembler documentAssembler;

    @Autowired
    public DocumentController(DocumentService documentService, DocumentAssembler documentAssembler) {
        this.documentService = documentService;
        this.documentAssembler = documentAssembler;
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Document>>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        List<EntityModel<Document>> entityModels = documents.stream()
                .map(documentAssembler::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(entityModels);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<EntityModel<Document>> getDocument(@PathVariable Long id) {
    //     Optional<Document> document = documentService.getDocumentById(id);
    //     return document.map(doc -> ResponseEntity.ok(documentAssembler.toModel(doc)))
    //             .orElse(ResponseEntity.notFound().build());
    // }

    // @PostMapping
    // public ResponseEntity<EntityModel<Document>> createDocument(@RequestBody Document document) {
    //     Document createdDocument = documentService.createDocument(document);
    //     return ResponseEntity
    //             .created(linkTo(methodOn(DocumentController.class).getDocument(createdDocument.getId())).toUri())
    //             .body(documentAssembler.toModel(createdDocument));
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<EntityModel<Document>> updateDocument(@PathVariable Long id, @RequestBody Document updatedDocument) {
    //     Document document = documentService.updateDocument(id, updatedDocument);
    //     return ResponseEntity.ok(documentAssembler.toModel(document));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
    //     documentService.deleteDocument(id);
    //     return ResponseEntity.noContent().build();
    // }
}
