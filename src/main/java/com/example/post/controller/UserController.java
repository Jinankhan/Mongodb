package com.example.post.controller;

import com.example.post.dto.user.request.UserRequest;
import com.example.post.dto.user.response.UserResponse;
import com.example.post.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private  final UserService userService;
   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam String email)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers()
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserAllUsers());
    }

    @PostMapping
    public  ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
    {
        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }



}
