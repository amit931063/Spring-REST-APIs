package com.amit.springbootwebtutorial.springbootwebtutorial.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
