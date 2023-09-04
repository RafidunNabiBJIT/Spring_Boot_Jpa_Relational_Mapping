package com.jpa.crud.exception;

public class BookAlreadyExistsCustomException extends Exception{
    private String message = "Book already exists.";
    public BookAlreadyExistsCustomException(String message) {
        super(message);
    }
}
