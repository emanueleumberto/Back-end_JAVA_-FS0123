package com.epicode.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.project.security.entity.ERole;
import com.epicode.project.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
