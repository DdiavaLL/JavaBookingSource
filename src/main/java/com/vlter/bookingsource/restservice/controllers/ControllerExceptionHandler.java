package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.exceptions.ControllerException;
import com.vlter.bookingsource.restservice.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Tereshchenko on 23.02.2021.
 */

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<ControllerException> handleValidationException(ValidationException ex) {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.BAD_REQUEST.value(), "Ошибка валидации! " + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
