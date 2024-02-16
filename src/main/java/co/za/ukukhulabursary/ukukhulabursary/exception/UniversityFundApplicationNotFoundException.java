package co.za.ukukhulabursary.ukukhulabursary.exception;

public class UniversityFundApplicationNotFoundException extends RuntimeException {

    public UniversityFundApplicationNotFoundException(long univeristyId) {
        super("University fund application for university with id " + univeristyId + " not found!");
    }
}
