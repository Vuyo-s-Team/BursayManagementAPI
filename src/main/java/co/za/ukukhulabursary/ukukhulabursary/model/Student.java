package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private  long studentID;
    private  String idNumber;
    private Date birthDate;
    private short age;
    private  User user;
    private  Gender gender;
    private  Race race;
    private  University university;
}
