package com.haiss.shoppingcart.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorObject> handleDuplicate(DuplicateException ex) {
        return new ResponseEntity<ErrorObject>(ex.getErrorBody(), ex.getStatus());
    }

    @ExceptionHandler( NotFoundException.class)
    public ResponseEntity<ErrorObject> handleNotFoundError(NotFoundException ex) {
        return new ResponseEntity<ErrorObject>(ex.getErrorBody(), ex.getStatus());
    }

    @ExceptionHandler( {MethodArgumentNotValidException.class, DataIntegrityViolationException.class, HttpMessageNotReadableException.class})

    public ResponseEntity<ErrorObject> handleValidatioNError(Exception ex) {
        System.out.println("Validation Failed" + ex);
        ErrorObject errorBody = new ErrorObject("Validation Failed", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorBody, errorBody.status());

    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorObject> handleAccDenied(AccessDeniedException ex ) {
        ErrorObject errorBody = new ErrorObject("Not Authorized", HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(errorBody, errorBody.status());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleException(Exception ex) {
        System.out.println("Unhandeld Exception" + ex);
        ErrorObject errorBody = new ErrorObject("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorBody, errorBody.status());
    }
}
