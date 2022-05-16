package com.example.yotiassessment.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponseException extends YotiException {

  
    private static final long serialVersionUID = 1L;
    
    private HttpStatus status;

    public ApiResponseException(String message,HttpStatus status) {
	super(message);
	this.status=status;
    }

    public HttpStatus getStatus() {
	return status;
    }

    public void setStatus(HttpStatus status) {
	this.status = status;
    }
    

}
