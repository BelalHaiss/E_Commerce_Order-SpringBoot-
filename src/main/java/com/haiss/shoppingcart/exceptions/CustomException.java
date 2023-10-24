package com.haiss.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;

public interface CustomException {
    HttpStatus getStatus();
    ErrorObject getErrorBody();

}
