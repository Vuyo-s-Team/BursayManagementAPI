package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UniversityFundApplication {

    private long id;
    private LocalDate fundingYear;
    private Status status;
    private String comment;
    private long universityID;
}
