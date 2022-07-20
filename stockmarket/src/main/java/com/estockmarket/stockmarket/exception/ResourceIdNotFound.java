package com.estockmarket.stockmarket.exception;

public class ResourceIdNotFound extends RuntimeException {
	
    
    private static final long serialVersionUID = 1L;
     
    public ResourceIdNotFound() {
        super();
    }
 
    public ResourceIdNotFound(String message) {
        super(message);
    }
 
    public ResourceIdNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
    

