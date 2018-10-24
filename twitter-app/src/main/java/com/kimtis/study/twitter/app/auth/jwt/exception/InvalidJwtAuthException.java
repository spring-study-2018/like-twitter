package com.kimtis.study.twitter.app.auth.jwt.exception;

public class InvalidJwtAuthException extends Exception{

    public InvalidJwtAuthException(String message) {
        super(message);
    }
    public InvalidJwtAuthException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidJwtAuthException(Throwable cause) {
        super(cause);
    }
}
