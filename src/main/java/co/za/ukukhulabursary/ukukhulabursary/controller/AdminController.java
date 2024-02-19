package co.za.ukukhulabursary.ukukhulabursary.controller;


import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import co.za.ukukhulabursary.ukukhulabursary.model.User;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UserRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.implementation.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/bbdadmin")
public class AdminController {

    private  final  AdminService adminService;
    @GetMapping("/funded/students")
    public  void SeeAllFundedStudents(){

    }

    @PutMapping ("/application/universities")
    public void  UpdateUniversityApplication(){

    }

    @PutMapping ("/application/students")
    public void  UpdateStudentApplication(){

    }

    @GetMapping("/university/funds/year/{year}")
    public  List<UniversityYearlyFundAllocation> AllocateUninversityFunds(@PathVariable int year){
       return adminService.SerchAllUniversitiesFundingByYear(year);
    }
    @GetMapping("/funded/studentz")
    public  void ViewAllFinalYearStudents(){

    }



}
