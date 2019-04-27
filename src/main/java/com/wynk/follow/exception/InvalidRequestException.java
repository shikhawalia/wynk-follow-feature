package com.wynk.follow.exception;

public class InvalidRequestException extends Exception {

    private String status;
    private String message;

    public InvalidRequestException() {
        this.status = "failed";
        this.message = "invalid input parameter";
    }

    public InvalidRequestException(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public InvalidRequestException(Exception ex) {
        super(ex);
        this.status = "failed";
        this.message = "invalid input parameter";
    }

    public InvalidRequestException(String status, String message, Exception ex) {
        super(message, ex);
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
