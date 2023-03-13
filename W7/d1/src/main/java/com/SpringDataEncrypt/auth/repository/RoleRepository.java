package com.SpringDataEncrypt.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringDataEncrypt.auth.entity.ERole;
import com.SpringDataEncrypt.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
