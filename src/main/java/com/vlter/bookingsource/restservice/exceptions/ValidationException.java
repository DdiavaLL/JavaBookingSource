package com.vlter.bookingsource.restservice.exceptions;

/**
 * Created by Tereshchenko on 23.02.2021.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {super(message);}
}
