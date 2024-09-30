package com.riwi.superSchool.services;

import com.riwi.superSchool.entities.UserEntity;
import com.riwi.superSchool.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepo userRepo;

    public UserEntity SaveUser(UserEntity user) {
        return userRepo.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

}
