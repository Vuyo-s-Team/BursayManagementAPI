package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

@Data
public class HeadOfDepartment {
    private long id;
    private University university;
    private long userID;
    private long departmentID;

}
