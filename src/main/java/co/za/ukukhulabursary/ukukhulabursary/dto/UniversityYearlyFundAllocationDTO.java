package co.za.ukukhulabursary.ukukhulabursary.dto;

import co.za.ukukhulabursary.ukukhulabursary.model.University;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UniversityYearlyFundAllocationDTO {
    private double budget;
    private long universityId;
    private long yearlyFundId;
}
