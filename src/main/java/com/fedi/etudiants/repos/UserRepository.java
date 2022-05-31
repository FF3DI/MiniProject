package com.fedi.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedi.etudiants.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
