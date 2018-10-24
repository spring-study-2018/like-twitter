package com.kimtis.study.twitter.app.auth.jwt.exception;

public class PayloadMismatchException extends Exception {

    public PayloadMismatchException(String message) {
        super(message);
    }
    public PayloadMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    public PayloadMismatchException(Throwable cause) {
        super(cause);
    }
}