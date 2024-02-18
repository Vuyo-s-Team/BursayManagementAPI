package co.za.ukukhulabursary.ukukhulabursary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.za.ukukhulabursary.ukukhulabursary.link.DocumentAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import co.za.ukukhulabursary.ukukhulabursary.service.implementation.DocumentService;

import java.util.List;
import java.util.stream.Collectors;

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

}
