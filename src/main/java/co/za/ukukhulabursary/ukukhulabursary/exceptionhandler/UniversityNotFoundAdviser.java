package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import co.za.ukukhulabursary.ukukhulabursary.exception.UniversityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UniversityNotFoundAdviser {

    @ResponseBody
    @ExceptionHandler(UniversityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String universityNotFoundExceptionHandler(UniversityNotFoundException except) {
        return except.getMessage();
    }
}
