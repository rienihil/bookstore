package com.example.as33.services;

import com.example.as33.models.User;
import com.example.as33.repositories.UserRepositoryInterface;
import com.example.as33.services.interfaces.UserServiceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepositoryInterface repo;

    public UserService(UserRepositoryInterface repo) {
        this.repo = repo;
    }
    @Override
    public List<User> getAllUsers() {
        return repo.findAll(Sort.by("id"));
    }

    @Override
    public User getUserById(int id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User getUserByUsername(String username) {
        return repo.findUserByUsername(username);
    }

    @Override
    public User createUser(User user) {
        return repo.saveAndFlush(user);
    }

    @Override
    public void deleteUserById(int id) {
        repo.deleteById(id);
    }
}
