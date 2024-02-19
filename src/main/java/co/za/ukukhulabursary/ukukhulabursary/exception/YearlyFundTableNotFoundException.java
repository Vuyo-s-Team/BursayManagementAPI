package co.za.ukukhulabursary.ukukhulabursary.exception;

public class YearlyFundTableNotFoundException extends RuntimeException{
    public YearlyFundTableNotFoundException (long id) {
        super("Yearly Fund with id " + id + " could not be found!");
    }
}
