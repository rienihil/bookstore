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
    private int category_id;

    public Book(String title,String author,double price,int category_id){
        this.title=title;
        this.author=author;
        this.price=price;
        this.category_id=category_id;
    }

    public Book(int id,String title,String author,double price, int category_id){
        this.title=title;
        this.author=author;
        this.price=price;
        this.category_id=category_id;
        setId(id);
    }

    @JoinTable(name = "purchases",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")}
    )

    public String toString(){
        return id+". "+title+" - "+author;
    }
}

