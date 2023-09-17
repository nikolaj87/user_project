package pl.nik.user_project.exception_layer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.nik.user_project.exception_layer.exceptions.BadRequestBodyJson;
import pl.nik.user_project.exception_layer.exceptions.NoNikalajException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(NoNikalajException.class)
    public ResponseEntity<Response> handleException (NoNikalajException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<BadRequestBodyJson> handlerValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new BadRequestBodyJson(errors),
                HttpStatus.BAD_REQUEST);
    }
}
