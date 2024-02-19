package com.example.as33.services.interfaces;

import com.example.as33.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByUsername(String username);
    User createUser(User user);
    void deleteUserById(int id);
}