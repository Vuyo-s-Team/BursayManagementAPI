package co.za.ukukhulabursary.ukukhulabursary.controller;

import co.za.ukukhulabursary.ukukhulabursary.link.ProvinceAssembler;
import co.za.ukukhulabursary.ukukhulabursary.link.StatusAssembler;
import co.za.ukukhulabursary.ukukhulabursary.link.UniversityAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.Province;
import co.za.ukukhulabursary.ukukhulabursary.model.Status;
import co.za.ukukhulabursary.ukukhulabursary.model.University;
import co.za.ukukhulabursary.ukukhulabursary.service.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final StatusAssembler statusAssembler;

    @GetMapping
    public CollectionModel<EntityModel<University>> allUniversities() {
        List<EntityModel<University>> universities = universityService.retrieveAllUniversities()
                .stream()
                .map(universityAssembler::toModel)
                .toList();
        return CollectionModel.of(
                universities,
                linkTo(methodOn(UniversityController.class).allUniversities()).withRel("universities")
        );
    }

    @GetMapping("/{universityId}")
    public EntityModel<University> oneUniversity(@PathVariable("universityId") long universityId) {
        return universityAssembler.toModel(
                universityService.retrieveSingleUniversity(universityId)
        );
    }

    @GetMapping("/status/{statusId}")
    public CollectionModel<EntityModel<University>> allUniversityByStatus(@PathVariable("statusId") Long statusId) {
        List<EntityModel<University>> universities = universityService.retrieveAllUniversitiesByStatusId(statusId)
                .stream()
                .map(universityAssembler::toModel)
                .toList();
        return CollectionModel.of(
                universities,
                linkTo(methodOn(UniversityController.class).allUniversityByStatus(statusId)).withSelfRel()
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

    @GetMapping("/statuses")
    public CollectionModel<EntityModel<Status>> allStatuses() {
        List<EntityModel<Status>> statuses = universityService.retrieveAllStatuses()
                .stream()
                .map(statusAssembler::toModel)
                .toList();
        return CollectionModel.of(
                statuses,
                linkTo(methodOn(UniversityController.class).allStatuses()).withSelfRel()
        );
    }
}
