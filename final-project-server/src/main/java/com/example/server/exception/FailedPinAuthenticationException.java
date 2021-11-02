package com.example.server.exception;


public class FailedPinAuthenticationException extends RuntimeException{
    public FailedPinAuthenticationException(String message) {
        super(message);
    }

    public FailedPinAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedPinAuthenticationException(Throwable cause) {
        super(cause);
    }

    public FailedPinAuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FailedPinAuthenticationException() {
    }
}
