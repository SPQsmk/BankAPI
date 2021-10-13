package com.bootcamp.exception;

public class NegativeDepositException extends RuntimeException {
    public NegativeDepositException() {
    }

    public NegativeDepositException(String message) {
        super(message);
    }
}
