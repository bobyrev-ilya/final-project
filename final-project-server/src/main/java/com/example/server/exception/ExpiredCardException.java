package com.example.server.exception;


public class ExpiredCardException extends RuntimeException {
    public ExpiredCardException() {
    }

    public ExpiredCardException(String message) {
        super(message);
    }

    public ExpiredCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpiredCardException(Throwable cause) {
        super(cause);
    }

    public ExpiredCardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
