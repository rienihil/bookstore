package com.example.as33.controllers;

import com.example.as33.models.User;
import com.example.as33.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserServiceInterface service;

    public UserController(UserServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<User> getAll(){
        return service.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getById(@PathVariable("user_id") int id){
        try {
            User user = service.getUserById(id);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by_title/{title}")
    public User getUserByTitle(@PathVariable String username) {
        return service.getUserByUsername(username);
    }


    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }
    public void deleteUser(@PathVariable int id) {

        service.deleteUserById(id);
    }
}
