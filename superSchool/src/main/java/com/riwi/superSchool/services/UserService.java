package com.riwi.superSchool.services;

import com.riwi.superSchool.dtos.request.UserPrincipal;
import com.riwi.superSchool.model.UserEntity;
import com.riwi.superSchool.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepo userRepo;

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
