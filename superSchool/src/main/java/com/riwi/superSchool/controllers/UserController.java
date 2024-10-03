package com.riwi.superSchool.controllers;

import com.riwi.superSchool.model.UserEntity;
import com.riwi.superSchool.enums.UserRole;
import com.riwi.superSchool.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @Operation(summary = "Create a new user", description = "Endpoint to create an user")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    public ResponseEntity<UserEntity> createUser(
            @Parameter(description = "Name") @RequestParam("Name") String name,
            @Parameter(description = "email") @RequestParam("Email") String email,
            @Parameter(description = "Password")@RequestParam("Password") String password,
            @Parameter(description = "Role")@RequestParam("Role")UserRole userRole
            ) {
        UserEntity user = new UserEntity();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(userRole);
        try {
            return ResponseEntity.ok(userService.SaveUser(user));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(user);
        }
    }

    @GetMapping
    @Operation (summary = "Get all users", description = "Endpoint to get all users")
    @ApiResponse(responseCode = "200", description = "Users gathered successfully")
    public List<UserEntity> getUsers() {
        try {
            List<UserEntity> users = userService.getAllUsers();
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    @Operation (summary = "Gets suer by id", description = "Endpoint to get user By Id")
    @ApiResponse(responseCode = "200", description = "User successfully found by id")
    @ApiResponse(responseCode = "404", description = "User could not be found by id")
    public ResponseEntity<UserEntity> getById(@PathVariable Long id) {
        try {
            UserEntity user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates an user by the given ID", description = "Endpoint to update user")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id,
                                                 @Parameter(description = "Name") @RequestParam("Name") String name,
                                                 @Parameter(description = "email") @RequestParam("Email") String email,
                                                 @Parameter(description = "Password")@RequestParam("Password") String password,
                                                 @Parameter(description = "Role")@RequestParam("Role")UserRole userRole) {
        try{
            UserEntity user = userService.getUserById(id);
            user.setUsername(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(userRole);
            return ResponseEntity.ok(userService.SaveUser(user));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes an suer by id", description = "Endpoint to delete an user by id")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @ApiResponse(responseCode = "404", description = "User could not be found to be deleted")
    public void deleteUser(@PathVariable Long id) {
        try{
            userService.deleteUserById(id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
