package co.za.ukukhulabursary.ukukhulabursary.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private Contact contact;
}
