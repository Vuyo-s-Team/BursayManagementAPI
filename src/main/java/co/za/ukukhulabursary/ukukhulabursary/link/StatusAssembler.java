package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.controller.UniversityController;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StatusAssembler implements RepresentationModelAssembler<Status, EntityModel<Status>> {
    @Override
    public EntityModel<Status> toModel(Status entity) {
        EntityModel<Status> entityModel = EntityModel.of(
                entity
        );
        return entityModel;
    }
}
