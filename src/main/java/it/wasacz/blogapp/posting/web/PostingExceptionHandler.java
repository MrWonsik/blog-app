package it.wasacz.blogapp.posting.web;

import it.wasacz.blogapp.posting.exception.PostNotFoundException;
import it.wasacz.blogapp.posting.exception.PostingException;
import it.wasacz.blogapp.shared.web.ErrorMessage;
import it.wasacz.blogapp.shared.web.ErrorResponse;
import it.wasacz.blogapp.shared.web.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostingExceptionHandler {

    @ExceptionHandler(PostingException.class)
    ResponseEntity<ErrorResponse> handlePostingException(PostingException exception) {
        return errorResponse(ErrorCode.GENERAL_ERROR);
    }

    @ExceptionHandler(PostNotFoundException.class)
    ResponseEntity<ErrorResponse> handlePostNotFound(PostNotFoundException exception) {
        return errorResponse(ErrorCode.POST_NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> errorResponse(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.httpStatus)
                .body(ResponseBuilder.error(new ErrorMessage(errorCode.name(), errorCode.message)));
    }
}
