package com.example.as33.services.interfaces;

import com.example.as33.models.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getAllBooks();
    Book getBookById(int id);
    List<Book> getBookByTitle(String title);
    Book createBook(Book book);
    void deleteBookById(int id);
    List<Book> getBookByAuthor(String author);
}
