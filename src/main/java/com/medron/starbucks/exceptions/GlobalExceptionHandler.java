package com.medron.starbucks.exceptions;

import com.medron.starbucks.constants.CustomerExceptionConstant;
import com.medron.starbucks.exceptions.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL SERVER ERROR"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails = ErrorDetails.builder()
                .path(webRequest.getContextPath())
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .errorCode(CustomerExceptionConstant.ENTITY_NOT_FOUND).build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
