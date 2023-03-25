package com.atmspring.atmspring.Exception;

public class InvalidPasswordException extends RuntimeException{
    public static final String message = "Password is incorrect";

    public InvalidPasswordException() {
        super(message);
    }
}