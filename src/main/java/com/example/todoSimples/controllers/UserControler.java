package com.example.todoSimples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoSimples.Models.User;
import com.example.todoSimples.services.UserService;


@RestController
@RequestMapping("/user")
@Validated
public class UserControler {


    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = this.userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(CreateUser.class)
    public ResposeEntity<Void> create 

    


}
