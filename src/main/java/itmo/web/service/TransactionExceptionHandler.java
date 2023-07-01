package itmo.web.service;

import itmo.web.model.NoAccountException;
import itmo.web.model.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionExceptionHandler {
    @ExceptionHandler(NoAccountException.class)
    public ResponseEntity<String> handle(NoAccountException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<String> handle(NotEnoughMoneyException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
