package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

@Data
public class User {
    private long userID;
    private String firstName;
    private String lastName;
    private ContactDetails contactDetails;
}
