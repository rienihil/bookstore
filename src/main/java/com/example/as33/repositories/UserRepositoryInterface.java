package com.example.as33.repositories;

import com.example.as33.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
