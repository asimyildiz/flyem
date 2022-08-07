package com.flyem.microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Represents the exception method that is being used when a resource cannot be found 
 * @version fares-0.0.4-SNAPSHOT
 * @since fares-0.0.4-SNAPSHOT
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    /**
     * constructor for ResourceNotFoundException
     * @since fares-0.0.4-SNAPSHOT
     */
    public ResourceNotFoundException(String message){
        super(message);
    }
}