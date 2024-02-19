package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import co.za.ukukhulabursary.ukukhulabursary.exception.HeadOfDepartmentNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

public class HeadOfDepartmentNotFoundAdviser {

    @ResponseBody
    @ExceptionHandler(HeadOfDepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EntityModel<Map<String, String>> headOfDepartmentNotFoundExceptionHandler(HeadOfDepartmentNotFoundException except){
        return EntityModel.of(
                Map.of("message", except.getMessage())
        );
    }
}
