package co.za.ukukhulabursary.ukukhulabursary.exception;

public class HeadOfDepartmentNotFoundException extends RuntimeException{
    public HeadOfDepartmentNotFoundException(long id){
        super("Head Of Department with ID "+ id+" not found");
    }
}
