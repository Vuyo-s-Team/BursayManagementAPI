package co.za.ukukhulabursary.ukukhulabursary.exception;

import co.za.ukukhulabursary.ukukhulabursary.model.ContactDetails;

public class ContactDetailsNotFoundException extends RuntimeException{
    public ContactDetailsNotFoundException(long id) {
        super("Contact with id " + id + " could not be found!");
    }
}
