package com.haiss.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(value = {DuplicateException.class})
    public ResponseEntity<ErrorObject> handleDuplicate(DuplicateException ex) {

        HttpStatus statusCode = HttpStatus.CONFLICT;
        ErrorObject errObject = new ErrorObject(ex.getMessage(), statusCode);
        return new ResponseEntity<ErrorObject>(errObject, statusCode);
    }
}
