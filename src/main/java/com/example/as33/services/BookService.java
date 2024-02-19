package com.example.as33.services;

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
    public List<Book> getAllBooks() {
        return repo.findAll(Sort.by("id"));
    }

    @Override
    public Book getBookById(int id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return repo.findBookByTitle(title);
    }

    @Override
    public Book createBook(Book book) {
        return repo.saveAndFlush(book);
    }

    @Override
    public void deleteBookById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return repo.findBookByAuthor(author);
    }
}
