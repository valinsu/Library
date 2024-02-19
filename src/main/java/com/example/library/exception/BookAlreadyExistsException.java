package com.example.library.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String isbn){
        super("A book with ISBN" + isbn + " already exists");
    }

}
