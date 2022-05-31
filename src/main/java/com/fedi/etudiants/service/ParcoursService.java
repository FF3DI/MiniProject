package com.fedi.etudiants.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fedi.etudiants.entities.Parcours;


public interface ParcoursService {
	List<Parcours> getAllParcourss();

	Parcours saveParcours(Parcours parcours);
	Page<Parcours> getAllParcourssParPage(int page, int size);
	void deleteParcoursById(Long id);
	Parcours getParcours(Long id);
	
	Parcours updateParcours(Parcours c);
}
