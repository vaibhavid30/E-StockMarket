package com.estockmarket.stockmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerService {
	
	
	
	    @ExceptionHandler(ResourceIdNotFound.class)
	    public ResponseEntity<String> sendResponseError(ResourceIdNotFound e){
	    	//System.out.println("Inside DiscounIdNotfound exception");
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(DataNotAvailable.class)
	    public ResponseEntity<String> sendResponseError(DataNotAvailable e){
	    	//System.out.println("Inside DiscounIdNotfound exception");
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
    
}
