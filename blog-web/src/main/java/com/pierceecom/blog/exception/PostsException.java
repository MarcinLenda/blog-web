package com.pierceecom.blog.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class PostsException extends Exception {

    private final HttpStatus httpStatus;

    private PostsException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static PostsException create(final String message, final HttpStatus httpStatus) {
        return new PostsException(message, httpStatus);
    }
}
