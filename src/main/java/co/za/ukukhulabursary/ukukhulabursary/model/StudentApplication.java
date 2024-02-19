package co.za.ukukhulabursary.ukukhulabursary.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentApplication {
    
    private long applicationID ;
    private int yearOfStudies;
    private double averageGrade;
    private double amount;
    private LocalDate dateOfApplication;
    private String comment;
    private int studentID;
    private int programID;
    private String statusID;

}
