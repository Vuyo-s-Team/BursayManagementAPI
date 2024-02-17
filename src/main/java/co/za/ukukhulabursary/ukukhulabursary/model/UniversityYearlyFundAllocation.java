package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UniversityYearlyFundAllocation {

    private long id;
    private double money;
    private double remainingBudget;
    private University university;
    private LocalDate date;
}
