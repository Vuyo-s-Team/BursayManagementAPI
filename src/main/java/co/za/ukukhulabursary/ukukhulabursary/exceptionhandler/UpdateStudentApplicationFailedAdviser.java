package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import java.util.Map;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.za.ukukhulabursary.ukukhulabursary.exception.UpdateStudentApplicationFailedException;

public class UpdateStudentApplicationFailedAdviser {
    @ResponseBody
    @ExceptionHandler(UpdateStudentApplicationFailedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EntityModel<Map<String, String>> documentNotFoundExceptionHandler(UpdateStudentApplicationFailedException except) {
        return EntityModel.of(
                Map.of("message", except.getMessage())
        );
    }
}
