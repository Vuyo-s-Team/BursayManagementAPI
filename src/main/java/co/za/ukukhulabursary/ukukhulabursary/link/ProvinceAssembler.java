package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.controller.UniversityController;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProvinceAssembler implements RepresentationModelAssembler<Province, EntityModel<Province>> {
    @Override
    public EntityModel<Province> toModel(Province province) {
        return EntityModel.of(
                province,
                linkTo(methodOn(UniversityController.class).allUniversities()).withRel("universities")
        );
    }
}
