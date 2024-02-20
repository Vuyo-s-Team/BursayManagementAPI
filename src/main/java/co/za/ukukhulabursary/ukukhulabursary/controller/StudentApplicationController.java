package co.za.ukukhulabursary.ukukhulabursary.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.za.ukukhulabursary.ukukhulabursary.link.StudentApplicationAssembler;
import co.za.ukukhulabursary.ukukhulabursary.model.StudentApplication;
import co.za.ukukhulabursary.ukukhulabursary.service.implementation.StudentApplicationService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/studentApplication")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;
   private final StudentApplicationAssembler studentApplicationAssembler;

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
                existingStudentApplication.setYearOfStudies(updatedStudentApplication.getYearOfStudies() != 0 ? updatedStudentApplication.getYearOfStudies() : existingStudentApplication.getYearOfStudies());
                existingStudentApplication.setAverageGrade(updatedStudentApplication.getAverageGrade() != 0.0 ? updatedStudentApplication.getAverageGrade() : existingStudentApplication.getAverageGrade());
                existingStudentApplication.setAmount(updatedStudentApplication.getAmount() != 0.0 ? updatedStudentApplication.getAmount() : existingStudentApplication.getAmount());
                existingStudentApplication.setDateOfApplication(updatedStudentApplication.getDateOfApplication() != null ? updatedStudentApplication.getDateOfApplication() : existingStudentApplication.getDateOfApplication());
                existingStudentApplication.setComment(updatedStudentApplication.getComment() != null ? updatedStudentApplication.getComment() : existingStudentApplication.getComment());
                existingStudentApplication.setStudentID(updatedStudentApplication.getStudentID() != 0 ? updatedStudentApplication.getStudentID() : existingStudentApplication.getStudentID());
                existingStudentApplication.setProgramID(updatedStudentApplication.getProgramID() != 0 ? updatedStudentApplication.getProgramID() : existingStudentApplication.getProgramID());
                existingStudentApplication.setStatusID(updatedStudentApplication.getStatusID() != 0 ? updatedStudentApplication.getStatusID() : existingStudentApplication.getStatusID());
                
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

    @GetMapping("/{id}/status")
    public ResponseEntity<String> getApplicationStatusById(@PathVariable Long id) {
        String status = studentApplicationService.getApplicationStatusById(id);
        return ResponseEntity.ok(status);
    }

}
