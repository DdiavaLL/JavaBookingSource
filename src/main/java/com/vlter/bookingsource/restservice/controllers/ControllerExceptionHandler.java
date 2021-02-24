package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.exceptions.*;
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

    @ExceptionHandler(ThereIsNoSuchUserException.class)
    protected ResponseEntity<ControllerException> handleThereIsNoSuchUserException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.NOT_FOUND.value(), "Данного пользователя не существует!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsNoSuchResourceException.class)
    protected ResponseEntity<ControllerException> handleThereIsNoSuchResourceException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.NOT_FOUND.value(), "Данного ресурса не существует!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ThereIsNoSuchReservationException.class)
    protected ResponseEntity<ControllerException> handleThereIsNoSuchReservationException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.NOT_FOUND.value(), "Данного резервирования ресурса не существует!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeleteUserException.class)
    protected ResponseEntity<ControllerException> handleDeleteUserException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.BAD_REQUEST.value(), "Ошибка во время удаления пользователя!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteResourceException.class)
    protected ResponseEntity<ControllerException> handleDeleteResourceException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.BAD_REQUEST.value(), "Ошибка во время удаления ресурса!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteReservationException.class)
    protected ResponseEntity<ControllerException> handleDeleteReservationException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.BAD_REQUEST.value(), "Ошибка во время удаления зарезервированного ресурса!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectUserSaveException.class)
    protected ResponseEntity<ControllerException> handleIncorrectUserSaveException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ошибка во время добавления нового пользователя!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IncorrectResourceSaveException.class)
    protected ResponseEntity<ControllerException> handleIncorrectResourceSaveException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ошибка во время добавления нового ресурса!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<ControllerException> handleIncorrectReservationSaveException() {
        return new ResponseEntity<ControllerException>(new ControllerException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ошибка во время добавления новой резервации ресурса!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
