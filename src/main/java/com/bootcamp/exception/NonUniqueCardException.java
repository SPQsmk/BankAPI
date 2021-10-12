package com.bootcamp.exception;

public class NonUniqueCardException extends RuntimeException {
    public NonUniqueCardException() {
        super();
    }

    public NonUniqueCardException(String message) {
        super(message);
    }
}
