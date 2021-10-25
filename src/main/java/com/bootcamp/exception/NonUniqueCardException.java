package com.bootcamp.exception;

public class NonUniqueCardException extends RuntimeException {
    public NonUniqueCardException() {
    }

    public NonUniqueCardException(String message) {
        super(message);
    }
}
