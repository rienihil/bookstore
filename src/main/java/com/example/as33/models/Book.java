package com.example.as33.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;

    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }

    public Book(int id,String title,String author){
        this.title=title;
        this.author=author;
        setId(id);
    }


    public String toString(){
        return id+". "+title+" - "+author;
    }
}

