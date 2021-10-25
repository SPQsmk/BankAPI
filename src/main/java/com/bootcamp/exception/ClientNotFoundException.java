package com.bootcamp.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
