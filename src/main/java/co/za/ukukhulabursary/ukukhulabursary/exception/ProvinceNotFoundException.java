package co.za.ukukhulabursary.ukukhulabursary.exception;

public class ProvinceNotFoundException extends RuntimeException {

    public ProvinceNotFoundException(long id) {
        super("Province with id " + id + " could not be found!");
    }
}
