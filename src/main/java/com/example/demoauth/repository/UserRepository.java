package com.example.demoauth.repository;

import com.example.demoauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Fedor Danilov 29.10.2021
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String Username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
