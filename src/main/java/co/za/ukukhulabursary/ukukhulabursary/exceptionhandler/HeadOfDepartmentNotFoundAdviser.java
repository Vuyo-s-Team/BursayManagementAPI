package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import co.za.ukukhulabursary.ukukhulabursary.exception.HeadOfDepartmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HeadOfDepartmentNotFoundAdviser {

    @ResponseBody
    @ExceptionHandler(HeadOfDepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String headOfDepartmentNotFoundException(HeadOfDepartmentNotFoundException exception){
        return exception.getMessage();
    }
}
