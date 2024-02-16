package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import co.za.ukukhulabursary.ukukhulabursary.exception.ProvinceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProvinceNotFoundAdviser {

    @ResponseBody
    @ExceptionHandler(ProvinceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String provinceNotFoundExceptionHandler(ProvinceNotFoundException except) {
        return except.getMessage();
    }
}
