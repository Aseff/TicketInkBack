package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping("/add")
    public  ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public  ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<User> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
