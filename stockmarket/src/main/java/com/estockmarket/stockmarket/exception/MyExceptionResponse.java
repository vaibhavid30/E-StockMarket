package com.estockmarket.stockmarket.exception;

import java.time.LocalDateTime;

public class MyExceptionResponse {
    
    private String message;
    private LocalDateTime now;
    private int status;


    public MyExceptionResponse(String message, int s) {
        this.message = message;
        this.now = LocalDateTime.now();
        this.status = s;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    public LocalDateTime getNow() {
        return this.now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", now='" + getNow() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
