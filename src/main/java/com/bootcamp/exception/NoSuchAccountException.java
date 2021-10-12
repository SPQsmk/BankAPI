package com.bootcamp.exception;

public class NoSuchAccountException extends RuntimeException {
    public NoSuchAccountException() {
        super();
    }

    public NoSuchAccountException(String message) {
        super(message);
    }
}
