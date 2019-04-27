package com.wynk.follow.exception;

public class EntityNotFoundException extends Exception{

    String message;

    public EntityNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
