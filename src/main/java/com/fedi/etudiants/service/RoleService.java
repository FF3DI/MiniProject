package com.fedi.etudiants.service;

import java.util.List;

import com.fedi.etudiants.entities.Role;

public interface RoleService {
	List <Role> findAll();
	Role findByRole(String role);



}
