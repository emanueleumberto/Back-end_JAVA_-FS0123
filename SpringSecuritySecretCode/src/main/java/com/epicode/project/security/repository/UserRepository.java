package com.epicode.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.project.security.entity.AuthUser;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByEmail(String email);

    Optional<AuthUser> findByUsernameOrEmail(String username, String email);

    Optional<AuthUser> findByUsername(String username);
    
    Optional<AuthUser> findByActive(boolean active);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

	//List<AuthUser> findByCreditCard(String creditCard);
}
