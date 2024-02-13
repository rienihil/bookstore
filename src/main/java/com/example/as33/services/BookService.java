package com.example.as33.services;

import com.example.as33.exceptions.BookNotFoundException;
import com.example.as33.models.Book;
import com.example.as33.repositories.BookRepositoryInterface;
import com.example.as33.services.interfaces.BookServiceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {
    private final BookRepositoryInterface repo;

    public BookService(BookRepositoryInterface repo) {
        this.repo = repo;
    }
    @Override
    public List<Book> getAll() {
        return repo.findAll(Sort.by("id"));
    }

    @Override
    public Book getById(int id) {
        return repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book createBook(Book book) {
        return repo.save(book);
    }
}
