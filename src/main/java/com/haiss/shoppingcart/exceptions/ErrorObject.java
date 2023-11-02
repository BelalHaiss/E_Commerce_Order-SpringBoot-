package com.haiss.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorObject(String message, HttpStatus status) {
    public int getStatusCode() {
        return status.value();
    }

}
