package com.ut.loans.express.processing.exceptions;

public class InvalidFileTypeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidFileTypeException(String message) {
        super(message);
    }
}
