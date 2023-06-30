package itmo.web.web.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
@ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<String> handleException(NotEnoughMoneyException exception){
    return ResponseEntity.badRequest().body(exception.getMessage());
}
}
