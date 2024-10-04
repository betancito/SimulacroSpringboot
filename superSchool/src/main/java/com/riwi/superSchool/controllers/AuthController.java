package com.riwi.superSchool.controllers;

import com.riwi.superSchool.model.UserEntity;
import com.riwi.superSchool.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//controller to have login and register stored
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    @Operation(description = "create user entities")
    public UserEntity register(@RequestBody UserEntity user){
        return userService.SaveUser(user);
    }

    @PostMapping("/login")
    @Operation(description = "login dd")
    public String login(@RequestBody UserEntity user){
        return  userService.verify(user);
    }
}
