package com.example.as33.controllers;

import com.example.as33.exceptions.BookNotFoundException;
import com.example.as33.models.Book;
import com.example.as33.services.interfaces.BookServiceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookServiceInterface service;

    public BookController(BookServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Book> getAll(){
        return service.getAll();
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<Book> getById(@PathVariable("book_id") int id){
        try {
            Book book = service.getById(id);

            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (BookNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }
}
