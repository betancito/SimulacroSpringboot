package com.riwi.superSchool.services;

import com.riwi.superSchool.dtos.request.UserPrincipal;
import com.riwi.superSchool.model.UserEntity;
import com.riwi.superSchool.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.printf("User not found: %s", username);
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
