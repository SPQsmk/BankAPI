package com.bootcamp.exception;

public class NoSuchClientException extends RuntimeException {
    public NoSuchClientException() {
        super();
    }

    public NoSuchClientException(String message) {
        super(message);
    }
}
