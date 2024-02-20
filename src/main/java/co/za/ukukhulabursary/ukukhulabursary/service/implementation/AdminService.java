package co.za.ukukhulabursary.ukukhulabursary.service.implementation;


import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityMoneySpentDTO;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UniversityYearlyFundAllocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final UniversityYearlyFundAllocationRepository universityYearlyFundAllocationRepository;
     public List<UniversityYearlyFundAllocation> SerchAllUniversitiesFundingByYear(int year){
         return universityYearlyFundAllocationRepository.findAllUniversitiesFundingByYear( year);
     }
     public  List<UniversityMoneySpentDTO>SearchUniversityMoneySpentByYear(int year){
         return universityYearlyFundAllocationRepository.findUniverityAndTheMoneyTheirSpent( year);
     }

}
