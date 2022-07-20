package com.estockmarket.stockmarket.exception;

public class DataNotAvailable extends RuntimeException{

	private static final long serialVersionUID = 1L;
    
    public DataNotAvailable() {
        super();
    }
 
    public DataNotAvailable(String message) {
        super(message);
    }
 
    public DataNotAvailable(String message, Throwable cause) {
        super(message, cause);
    }
}
