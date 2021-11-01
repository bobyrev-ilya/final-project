package com.example.server.exception;


public class FailedPinAuthenticationException extends RuntimeException{
    public FailedPinAuthenticationException(String message) {
        super(message);
    }
}
