package co.za.ukukhulabursary.ukukhulabursary.link;

import co.za.ukukhulabursary.ukukhulabursary.controller.StudentApplicationController;
import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StudentApplicationAssembler implements RepresentationModelAssembler<StudentApplication, EntityModel<StudentApplication>> {
    @Override
    public EntityModel<StudentApplication> toModel(StudentApplication studentApplication) {
        EntityModel<StudentApplication> entityModel = EntityModel.of(
                studentApplication,
                linkTo(methodOn(StudentApplicationController.class).getStudentApplicationById(studentApplication.getApplicationID())).withSelfRel(),
                linkTo(methodOn(StudentApplicationController.class).getAllStudentApplications()).withRel("studentApplication")
        );
        return entityModel;
    }
}
