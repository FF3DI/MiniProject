package com.fedi.etudiants.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomEtud", types = { Etudiant.class })

public interface EtudiantProjection {
	public String getNomEtudiant();

}
