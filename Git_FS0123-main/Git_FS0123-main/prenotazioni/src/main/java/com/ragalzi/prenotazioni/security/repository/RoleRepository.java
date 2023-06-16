package com.ragalzi.prenotazioni.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragalzi.prenotazioni.security.entity.ERole;
import com.ragalzi.prenotazioni.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
