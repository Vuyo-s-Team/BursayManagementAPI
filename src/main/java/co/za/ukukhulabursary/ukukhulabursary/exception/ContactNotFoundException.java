package co.za.ukukhulabursary.ukukhulabursary.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(long id){
        super("Contact with id " + id + " could not be found!");
    }
}
