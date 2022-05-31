package com.fedi.etudiants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fedi.etudiants.entities.Parcours;
import com.fedi.etudiants.repos.ParcoursRepository;


@Service
public  class ParcoursServiceImpl implements ParcoursService {
	@Autowired
	ParcoursRepository parcoursRepository;
	
	@Override
	public List<Parcours> getAllParcourss() {
		return parcoursRepository.findAll();
	}
	 @Override
	    public Parcours saveParcours(Parcours parcours) {
	        return parcoursRepository.save(parcours);
	    }
	 @Override
	    public Page<Parcours> getAllParcourssParPage(int page, int size) {
	    return parcoursRepository.findAll(PageRequest.of(page, size));
	    }
	 
	 @Override
	    public void deleteParcoursById(Long id) {
	        parcoursRepository.deleteById(id);
	    }
	 
	 @Override
	    public Parcours getParcours(Long id) {
	        return parcoursRepository.findById(id).get();
	    }
	 @Override
	    public Parcours updateParcours(Parcours c) {
	        return parcoursRepository.save(c);
	    }


}
