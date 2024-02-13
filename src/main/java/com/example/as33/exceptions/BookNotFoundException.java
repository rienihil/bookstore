package com.example.as33.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(int id){
        super("Book with id = "+ id+" was not found.");
    };
}
