package co.za.ukukhulabursary.ukukhulabursary.controller;


import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityMoneySpentDTO;
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


    @GetMapping("/university/funds/{year}")
    public  List<UniversityYearlyFundAllocation> GettheUninversityFundsByYear(@PathVariable int year){
       return adminService.SerchAllUniversitiesFundingByYear(year);
    }
    @GetMapping("/university/money/{year}")
    public  List<UniversityMoneySpentDTO> SearchUninversityMoneySpentByYear(@PathVariable int year){
        return adminService.SearchUniversityMoneySpentByYear(year);
    }
    @GetMapping("/funded/students")
    public  void ViewAllFinalYearStudents(){

    }



}
