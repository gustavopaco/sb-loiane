package com.pacoprojects.controller;

import com.pacoprojects.exception.ExceptionObject;
import com.pacoprojects.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RecordNotFoundException.class})
    protected ResponseEntity<ExceptionObject> handleRecordNotFound(RecordNotFoundException exception) {
        return new ResponseEntity<>(ExceptionObject
                .builder()
                .message(exception.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .build(), HttpStatus.NOT_FOUND);
    }
}
