package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Map;

@ControllerAdvice
public class ApiExceptionAdviser {

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EntityModel<Map<String, String>> noHandlerFoundExceptionHandler(
            NoHandlerFoundException except) {
        return EntityModel.of(
                Map.of("message", except.getMessage())
        );
    }
}
