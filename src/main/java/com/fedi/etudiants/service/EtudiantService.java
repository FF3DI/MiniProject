package com.fedi.etudiants.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fedi.etudiants.entities.Parcours;
import com.fedi.etudiants.entities.Etudiant;

public interface EtudiantService {

	Etudiant saveEtudiant(Etudiant p);
	Etudiant updateEtudiant(Etudiant p);
	void deleteEtudiant(Etudiant p);
	void deleteEtudiantById(Long id);
	Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiants();
	List<Etudiant> findByNomEtudiant(String nom);
	List<Etudiant> findByNomEtudiantContains(String nom);
	List<Etudiant> findByNomCin (String nom, int cin);
	List<Etudiant> findByParcours (Parcours parcours);
	List<Etudiant> findByParcoursIdParc(Long id);
	List<Etudiant> findByOrderByNomEtudiantAsc();
	List<Etudiant> trierEtudiantsNomsCin();
	List<Etudiant> findByNomParcoursContains (String nom);

	
	
	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
}
