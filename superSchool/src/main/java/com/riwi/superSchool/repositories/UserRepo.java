package com.riwi.superSchool.repositories;

import com.riwi.superSchool.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
