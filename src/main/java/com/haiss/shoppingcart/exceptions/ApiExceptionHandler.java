package com.haiss.shoppingcart.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(value = {DuplicateException.class})
    public ResponseEntity<ErrorObject> handleDuplicate(DuplicateException ex) {
        return new ResponseEntity<ErrorObject>(ex.getErrorBody(), ex.getStatus());
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ErrorObject> handleNotFoundError(NotFoundException ex) {
        return new ResponseEntity<ErrorObject>(ex.getErrorBody(), ex.getStatus());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, DataIntegrityViolationException.class})

    public ResponseEntity<ErrorObject> handleValidatioNError(Exception ex) {
        System.out.println("Validation Failed" + ex);
        ErrorObject errorBody = new ErrorObject("Validation Failed", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorBody, errorBody.status());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleException(Exception ex) {
        ErrorObject errorBody = new ErrorObject("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(errorBody, errorBody.status());
    }
}
