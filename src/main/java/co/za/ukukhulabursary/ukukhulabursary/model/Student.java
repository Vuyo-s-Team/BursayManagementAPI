package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private  long StudentID;
    private  String IDNumber;
    private Date  BirthDate;
    private int Age;
    private  long UserID;
    private  long GenderID;
    private  long  RaceID;
    private  long UniversityID;
}
