package co.za.ukukhulabursary.ukukhulabursary.exception;

public class StatusNotFoundException extends RuntimeException {

    public StatusNotFoundException(long id) {
        super("Status with id " + id + " not found!");
    }
}
