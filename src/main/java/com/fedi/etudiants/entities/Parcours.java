package com.fedi.etudiants.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parcours {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idParc;
@NotNull

@Column(unique=true)
private String nomParc;
private String descriptionParc;
@JsonIgnore
@OneToMany(mappedBy = "parcours")
private List<Etudiant> etudiants;
public Parcours() {}
public Parcours(String nomParc, String descriptionParc, List<Etudiant> etudiants)
{

super();
this.nomParc = nomParc;
this.descriptionParc = descriptionParc;
this.etudiants = etudiants;
}
public Long getIdParc() {
return idParc;
}
public void setIdParc(Long idParc) {
this.idParc = idParc;
}
public String getNomParc() {
return nomParc;
}
public void setNomParc(String nomParc) {
this.nomParc = nomParc;
}
public String getDescriptionParc() {
return descriptionParc;
}
public void setDescriptionParc(String descriptionParc) {
this.descriptionParc = descriptionParc;
}
public List<Etudiant> getEtudiants() {
return etudiants;
}
public void setEtudiants(List<Etudiant> etudiants) {
this.etudiants = etudiants;
}
}
