package com.fedi.etudiants.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fedi.etudiants.entities.Parcours;


@RepositoryRestResource(path = "rest")
public interface ParcoursRepository extends JpaRepository<Parcours, Long> {

	
}
