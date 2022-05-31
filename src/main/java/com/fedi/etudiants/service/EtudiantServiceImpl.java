package com.fedi.etudiants.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fedi.etudiants.entities.Parcours;
import com.fedi.etudiants.entities.Etudiant;
import com.fedi.etudiants.repos.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public Etudiant saveEtudiant(Etudiant p) {
		return etudiantRepository.save(p);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant p) {
		return etudiantRepository.save(p);
	}

	@Override
	public void deleteEtudiant(Etudiant p) {
		etudiantRepository.delete(p);
	}

	@Override
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}
	
	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
	return etudiantRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Etudiant> findByNomEtudiant(String nom) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByNomEtudiant(nom);
	}

	@Override
	public List<Etudiant> findByNomEtudiantContains(String nom) {
		// TODO Auto-generated method stub
		return  etudiantRepository.findByNomEtudiantContains(nom);
	}

	@Override
	public List<Etudiant> findByNomCin(String nom, int cin) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByNomCin(nom, cin);

	}

	@Override
	public List<Etudiant> findByParcours(Parcours parcours) {
		// TODO Auto-generated method stub
		return  etudiantRepository.findByParcours(parcours);
	}

	@Override
	public List<Etudiant> findByParcoursIdParc(Long id) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByParcoursIdParc(id);

	}

	@Override
	public List<Etudiant> findByOrderByNomEtudiantAsc() {
		// TODO Auto-generated method stub
		return etudiantRepository.findByOrderByNomEtudiantAsc();

	}

	@Override
	public List<Etudiant> trierEtudiantsNomsCin() {
		// TODO Auto-generated method stub
		return etudiantRepository.trierEtudiantsNomsCin();
	}
	@Override
	public List<Etudiant> findByNomParcoursContains(String parcours) {
		
		return etudiantRepository.findByNomParcoursContains(parcours);
	}
}
