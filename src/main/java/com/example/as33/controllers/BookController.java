package com.example.as33.controllers;

import com.example.as33.models.Book;
import com.example.as33.services.interfaces.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceInterface service;

    public BookController(BookServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<Book> getBookById(@PathVariable("book_id") int id){
        try {
            Book book = service.getBookById(id);

            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        return service.getBookByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author) {
        return service.getBookByAuthor(author);
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }

    @DeleteMapping("/{book_id}")
    public void deleteBook(@PathVariable("book_id") int id) {

        service.deleteBookById(id);
    }
}
