package com.GestioneDispositivi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestioneDispositivi.entity.ERole;
import com.GestioneDispositivi.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
