package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.controller.DocumentController;
import co.za.ukukhulabursary.ukukhulabursary.model.Document;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DocumentAssembler implements RepresentationModelAssembler<Document, EntityModel<Document>> {
    @Override
    public EntityModel<Document> toModel(Document document) {
        return EntityModel.of(
                document,
                linkTo(methodOn(DocumentController.class).getAllDocuments()).withSelfRel(),
                linkTo(methodOn(DocumentController.class).getAllDocuments()).withRel("documents")
        );
    }
}
