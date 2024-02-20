package co.za.ukukhulabursary.ukukhulabursary.controller;


import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityMoneySpentDTO;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import co.za.ukukhulabursary.ukukhulabursary.model.User;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UserRepository;
import co.za.ukukhulabursary.ukukhulabursary.service.implementation.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public  List<UniversityMoneySpentDTO> SearchListUninversityMoneySpentByYear(@PathVariable int year){
        return adminService.SearchUniversityMoneySpentByYear(year);
    }
    @GetMapping("/university/money/{id}/{year}")
    public Optional<UniversityMoneySpentDTO> SearchUninversityMoneySpentByYear(@PathVariable int id, @PathVariable int year){
        return adminService.UniverityChecksHowMuchTheirSpentEachYear(year, id);
    }



}
