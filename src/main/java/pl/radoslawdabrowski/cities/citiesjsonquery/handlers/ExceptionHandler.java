package pl.radoslawdabrowski.cities.citiesjsonquery.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.Error;

@Slf4j
@RestController
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        return new ResponseEntity<>(new Error(ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Error> handleNullPointerException(NullPointerException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage(), HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
    }

}
