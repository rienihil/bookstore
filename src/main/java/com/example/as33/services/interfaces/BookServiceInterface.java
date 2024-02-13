package com.example.as33.services.interfaces;

import com.example.as33.models.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getAll();
    Book getById(int id);
    List<Book> findByTitle(String title);
    Book createBook(Book book);
}
