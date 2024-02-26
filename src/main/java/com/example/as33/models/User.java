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
    private int role_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Role role;


    public User(String username, int role_id){
        this.username=username;
        this.role_id=role_id;
    }

    public User(int id, String username,int role_id){
        this.username=username;
        this.role_id=role_id;
        setId(id);
    }

    @JoinTable(name = "purchases",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )

    public String toString(){
        return id+". "+username;
    }
}
