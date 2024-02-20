package co.za.ukukhulabursary.ukukhulabursary.service.implementation;


import co.za.ukukhulabursary.ukukhulabursary.dto.UniversityMoneySpentDTO;
import co.za.ukukhulabursary.ukukhulabursary.model.UniversityYearlyFundAllocation;
import co.za.ukukhulabursary.ukukhulabursary.repository.implementation.UniversityYearlyFundAllocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     public Optional<UniversityMoneySpentDTO> UniverityChecksHowMuchTheirSpentEachYear(int year, int universityID){
         return universityYearlyFundAllocationRepository.UniverityChecksHowMuchTheirSpentEachYear(year,universityID);
     }

}
