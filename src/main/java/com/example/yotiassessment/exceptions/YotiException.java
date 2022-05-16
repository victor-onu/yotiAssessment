package com.example.yotiassessment.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class YotiException extends RuntimeException{

    protected String message;
    
    public YotiException(String message) {
        this.message=message;
    }
}
