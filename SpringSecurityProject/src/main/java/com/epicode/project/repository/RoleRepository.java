package com.epicode.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.project.entity.ERole;
import com.epicode.project.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
