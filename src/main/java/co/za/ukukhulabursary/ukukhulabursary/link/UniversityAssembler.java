package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.model.University;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class UniversityAssembler implements RepresentationModelAssembler<University, EntityModel<University>> {
    @Override
    public EntityModel<University> toModel(University university) {
        EntityModel<University> entityModel = EntityModel.of(
                university
        );
        return entityModel;
    }
}
