package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.controller.UniversityController;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UniversityAssembler implements RepresentationModelAssembler<University, EntityModel<University>> {
    @Override
    public EntityModel<University> toModel(University university) {
        EntityModel<University> entityModel = EntityModel.of(
                university
        );

        if (university.getUniversityFundApplication() != null)
            entityModel.add(
                    linkTo(methodOn(UniversityController.class)
                            .allUniversityByStatus(university.getUniversityFundApplication().getStatus().getId()))
                            .withRel("university_by_status_id")
            );
        return entityModel;
    }
}
