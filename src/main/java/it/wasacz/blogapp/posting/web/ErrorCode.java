package it.wasacz.blogapp.posting.web;

import org.springframework.http.HttpStatus;

enum ErrorCode {
    GENERAL_ERROR("Something went wrong", HttpStatus.BAD_REQUEST),
    POST_NOT_FOUND("Post not found", HttpStatus.NOT_FOUND)
    ;

    final String message;
    final HttpStatus httpStatus;

    ErrorCode(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
