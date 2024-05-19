package com.one.loginpage.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;

    public BlogAPIException(HttpStatus status, String message) {
        this.httpStatus = status;
        this.message = message;
    }

    public BlogAPIException(HttpStatus httpStatus, String message, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
