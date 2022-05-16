package com.example.yotiassessment.exceptions;


public class InvalidCredentialException extends YotiException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidCredentialException() {
	super("Invalid data");
    }

    public InvalidCredentialException(String message) {
	super(message);
    }

}
