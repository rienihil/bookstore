package com.example.as33.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private int book_id;

    public Purchase(int user_id, int book_id){
        this.user_id=user_id;
        this.book_id=book_id;
    }

    public Purchase(int id,int user_id, int book_id){
        this.user_id=user_id;
        this.book_id=book_id;
        setId(id);
    }
}
