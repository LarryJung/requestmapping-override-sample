package com.larry.mvcsample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = AuthorizationException.class)
    public ResponseEntity<String> handleException(AuthorizationException exception) {
        System.out.println("handle authorization exception. " + exception.getRole());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getRole());
    }

}
