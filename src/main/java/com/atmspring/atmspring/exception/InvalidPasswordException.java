package com.atmspring.atmspring.exception;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends BaseException{

    public InvalidPasswordException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}