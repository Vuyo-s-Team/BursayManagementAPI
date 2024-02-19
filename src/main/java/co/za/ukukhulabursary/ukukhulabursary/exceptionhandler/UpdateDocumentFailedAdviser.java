package co.za.ukukhulabursary.ukukhulabursary.exceptionhandler;

import co.za.ukukhulabursary.ukukhulabursary.exception.UpdateDocumentFailedException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class UpdateDocumentFailedAdviser {

    @ResponseBody
    @ExceptionHandler(UpdateDocumentFailedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EntityModel<Map<String, String>> documentNotFoundExceptionHandler(UpdateDocumentFailedException except) {
        return EntityModel.of(
                Map.of("message", except.getMessage())
        );
    }
}