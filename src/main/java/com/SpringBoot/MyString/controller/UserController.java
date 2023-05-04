package com.SpringBoot.MyString.controller;

import com.SpringBoot.MyString.entity.User;
import com.SpringBoot.MyString.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    //build create users rest api  http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long userId){
        user.setId(userId);
        User updatedUser=userService.updateUser(user);
        return new ResponseEntity<>(updatedUser ,HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }
}
