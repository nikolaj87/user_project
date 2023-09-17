package pl.nik.user_project.exception_layer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.nik.user_project.exception_layer.exceptions.NoNikalajException;

@ControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(NoNikalajException.class)
    public ResponseEntity<Response> handleException (NoNikalajException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
