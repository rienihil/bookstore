package com.example.as33.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Author author;
    private double price;

    public Book(String title,Author author){
        this.title=title;
        this.author=author;
    }

    public Book(int id,String title,Author author){
        this.title=title;
        this.author=author;
        setId(id);
    }


    public String toString(){
        return id+". "+title+" - "+author;
    }
}

