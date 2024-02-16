package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityFundApplicationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UniversityFundApplicationNotFoundAdviser {

    @ResponseBody
    @ExceptionHandler(UniversityFundApplicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String universityFundApplicationNotFoundHandler(UniversityFundApplicationNotFoundException ex) {
        return ex.getMessage();
    }
}
