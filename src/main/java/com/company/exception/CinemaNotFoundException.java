package com.company.exception;

public class CinemaNotFoundException extends RuntimeException {
    public CinemaNotFoundException(String message) {
        super(message);
    }
}
