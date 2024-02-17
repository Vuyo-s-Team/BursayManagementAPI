package co.za.ukukhulabursary.ukukhulabursary.controller;

import co.za.ukukhulabursary.ukukhulabursary.link.ProvinceAssembler;
import co.za.ukukhulabursary.ukukhulabursary.link.UniversityAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.service.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/university")
public class UniversityController {

    private final IUniversityService universityService;
    private final ProvinceAssembler provinceAssembler;
    private final UniversityAssembler universityAssembler;

    @GetMapping
    public CollectionModel<EntityModel<University>> allUniversities() {
        List<EntityModel<University>> universities = universityService.retrieveAllUniversities()
                .stream()
                .map(universityAssembler::toModel)
                .toList();
        return CollectionModel.of(
                universities,
                linkTo(methodOn(UniversityController.class).allUniversities()).withSelfRel()
        );
    }

    @GetMapping("/provinces")
    public CollectionModel<EntityModel<Province>> allProvinces() {
        List<EntityModel<Province>> provinces = universityService.retrieveAllUniversityProvinces()
                .stream()
                .map(provinceAssembler::toModel)
                .toList();
        return CollectionModel.of(
                provinces,
                linkTo(methodOn(UniversityController.class).allProvinces()).withSelfRel()
        );
    }
}
