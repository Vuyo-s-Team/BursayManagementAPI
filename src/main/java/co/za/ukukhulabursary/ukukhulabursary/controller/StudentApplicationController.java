package co.za.ukukhulabursary.ukukhulabursary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.za.ukukhulabursary.ukukhulabursary.link.StudentApplicationAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import co.za.ukukhulabursary.ukukhulabursary.service.implementation.StudentApplicationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/studentApplication")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;
   private final StudentApplicationAssembler studentApplicationAssembler;

    @Autowired
    public StudentApplicationController(StudentApplicationService StudentApplicationService, StudentApplicationAssembler studentApplicationAssembler) {
        this.studentApplicationService = StudentApplicationService;
        this.studentApplicationAssembler = studentApplicationAssembler;
    }

    @GetMapping("")
    public ResponseEntity<List<EntityModel<StudentApplication>>> getAllStudentApplications() {
        List<StudentApplication> studentApplications = studentApplicationService.getAllStudentApplications();
        List<EntityModel<StudentApplication>> entityModels = studentApplications.stream()
                .map(studentApplicationAssembler::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(entityModels);
    }

    @PostMapping("")
    public ResponseEntity<EntityModel<StudentApplication>> saveStudentApplication(@RequestBody StudentApplication studentApplication) {
         studentApplicationService.saveStudentApplication(studentApplication);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentApplication> getStudentApplicationById(@PathVariable Long id) {
        Optional<StudentApplication> optionalDocument = studentApplicationService.getStudentApplicationById(id);
        return optionalDocument
                .map(document -> ResponseEntity.ok(document)) 
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentApplication> updateStudentApplication(@PathVariable int id, @RequestBody StudentApplication updatedStudentApplication) {
        try {
            Optional<StudentApplication> optionalExistingStudentApplication = studentApplicationService.getStudentApplicationById(id);

            if (optionalExistingStudentApplication.isPresent()) {
            StudentApplication existingStudentApplication = optionalExistingStudentApplication.get();
                existingStudentApplication.setYearOfStudies(updatedStudentApplication.getYearOfStudies());
                existingStudentApplication.setAverageGrade(updatedStudentApplication.getAverageGrade());
                existingStudentApplication.setAmount(updatedStudentApplication.getAmount());
                existingStudentApplication.setDateOfApplication(updatedStudentApplication.getDateOfApplication());
                existingStudentApplication.setComment(updatedStudentApplication.getComment());
                existingStudentApplication.setStudentID(updatedStudentApplication.getStudentID());
                existingStudentApplication.setProgramID(updatedStudentApplication.getProgramID());
                existingStudentApplication.setStatusID(updatedStudentApplication.getStatusID());
                StudentApplication updated = studentApplicationService.updateStudentApplication(existingStudentApplication);
                return ResponseEntity.ok(updated);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
