package com.example.as33.repositories;

import com.example.as33.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositoryInterface extends JpaRepository<Book, Integer> {

    List<Book> findBookByTitle(String title);

    List<Book> findBookByAuthor(String author);
}
