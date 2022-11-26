package com.newLibraryProjectt.LibraryProject.Ecxeption;

import jdk.nashorn.internal.codegen.ObjectClassGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LibraryException.class)
        public ResponseEntity<Object> libraryException(LibraryException exception) {
        ExceptionResponse response = new ExceptionResponse(exception.getErrorMessage(),
                exception.getUserErrorMessage(), exception.getErrorCode(), exception.getHttpstatus());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>  exceptionHandler(Exception exception){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), exception.getLocalizedMessage(),250,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}


