package co.za.ukukhulabursary.ukukhulabursary.exception;

public class UniversityNotFoundException extends RuntimeException {

    public UniversityNotFoundException(long id) {
        super("University with id " + id + " not found!");
    }
}
