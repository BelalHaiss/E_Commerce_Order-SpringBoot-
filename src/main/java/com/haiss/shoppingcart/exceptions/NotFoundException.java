package com.haiss.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException implements  CustomException {
    private final  ErrorObject errorBody ;
    private  final HttpStatus status = HttpStatus.NOT_FOUND;
    public NotFoundException(String msg) {

        super(msg);
        errorBody = new ErrorObject(msg,status);
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public ErrorObject getErrorBody() {
        return errorBody;
    }
}
