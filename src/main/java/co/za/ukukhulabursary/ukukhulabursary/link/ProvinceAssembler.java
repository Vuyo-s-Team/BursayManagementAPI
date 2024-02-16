package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;


public class ProvinceAssembler implements RepresentationModelAssembler<Province, EntityModel<Province>> {
    @Override
    public EntityModel<Province> toModel(Province province) {
        return EntityModel.of(
                province
        );
    }
}
