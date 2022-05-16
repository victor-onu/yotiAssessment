package com.example.yotiassessment.exceptions;


public class ConfigurationException extends YotiException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ConfigurationException() {
	super("Data is not unique");
    }

    public ConfigurationException(String message) {
	super(message);
    }

}
