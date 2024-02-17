package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.controller.UniversityController;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UniversityYearlyFundAllocationAssembler
        implements RepresentationModelAssembler<UniversityYearlyFundAllocation, EntityModel<UniversityYearlyFundAllocation>> {
    @Override
    public EntityModel<UniversityYearlyFundAllocation> toModel(UniversityYearlyFundAllocation entity) {
        EntityModel entityModel = EntityModel.of(
                entity
        );
        return entityModel;
    }
}
