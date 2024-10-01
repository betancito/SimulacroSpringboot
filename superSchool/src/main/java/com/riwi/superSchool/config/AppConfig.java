package com.riwi.superSchool.config;

import com.riwi.superSchool.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final UserRepo repo;
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User nor found"));
    }
}
