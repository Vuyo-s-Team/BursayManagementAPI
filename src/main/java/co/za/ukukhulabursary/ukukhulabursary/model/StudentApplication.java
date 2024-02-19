package co.za.ukukhulabursary.ukukhulabursary.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentApplication {

    private long applicationID ;
    private int yearOfStudy;
    private int averageGrade;
    private double amount;
    private LocalDate dateOfApplication;
    private String comment;
    private Student student;
    private Program programID;
    private Status status;


}
