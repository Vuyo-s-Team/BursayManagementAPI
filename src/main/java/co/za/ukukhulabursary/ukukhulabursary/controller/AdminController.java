package co.za.ukukhulabursary.ukukhulabursary.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/bbdadmin")
public class AdminController {

    @GetMapping("/funded/students")
    public  void SeeAllFundedStudents(){

    }

    @PutMapping ("/application/universities")
    public void  UpdateUniversityApplication(){

    }

    @PutMapping ("/application/students")
    public void  UpdateStudentApplication(){

    }

    @PutMapping("/funds/university")
    public  void  AllocateUninversityFunds(){

    }
    @GetMapping("/funded/students")
    public  void ViewAllFinalYearStudents(){

    }


}
