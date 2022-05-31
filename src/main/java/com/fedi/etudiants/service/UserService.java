package com.fedi.etudiants.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fedi.etudiants.entities.Role;
import com.fedi.etudiants.entities.User;

public interface UserService {
	  List <User> findAll();
		
		User saveUser(User e);
		User updateUser(User e);
		void deleteUser(User e);
		void deleteUserById(Long id);
		User getUser(Long id);
		Page<User> getAllUsersParPage(int page, int size);
		User findUserByUsername (String username);
		Role addRole(Role role);
		User addRoleToUser(String username, String rolename);

}
