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
    private double price;

    public Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public Book(int id,String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
        setId(id);
    }

    @JoinTable(name = "purchases",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")}
    )

    public String toString(){
        return id+". "+title+" - "+author;
    }
}

