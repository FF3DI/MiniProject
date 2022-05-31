package com.fedi.etudiants.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedi.etudiants.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);
	Optional<Role> findById(Long id);
	
}
