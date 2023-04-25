package com.turkcell.rentacar.core.exceptionold;

import com.turkcell.rentacar.common.constants.ExceptionConstant;
import com.turkcell.rentacar.core.exceptionold.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
/*
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,WebRequest webRequest){
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(exception.getMessage())
                .errorCode(ExceptionConstant.INTERNAL_SERVER_ERROR)
                .timestamp(LocalDateTime.now())
                .path(webRequest.getContextPath())
                .build();
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(resourceNotFoundException.getMessage())
                .errorCode(ExceptionConstant.ENTITY_NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .path(webRequest.getContextPath())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    */

}
