package com.kimtis.study.twitter.app.auth.jwt.exception;

public class HeaderMismatchException extends Exception {

    public HeaderMismatchException(String message) {
        super(message);
    }
    public HeaderMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    public HeaderMismatchException(Throwable cause) {
        super(cause);
    }
}