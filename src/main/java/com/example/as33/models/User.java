package com.example.as33.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String username;

    public User(String username){
        this.username=username;
    }

    public User(int id, String username){
        this.username=username;
        setId(id);
    }

    public String toString(){
        return id+". "+username;
    }
}
