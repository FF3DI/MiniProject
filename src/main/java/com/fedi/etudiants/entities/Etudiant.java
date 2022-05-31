package com.fedi.etudiants.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	@NotNull
	@Size (min = 4,max = 50)
	@Column(unique=true)
	private String nomEtudiant;
	@Min(value = 1000000)
	 @Max(value = 100000000)
	private int cinEtudiant;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateNaissance;
	@ManyToOne
private Parcours parcours;
	public Parcours getParcours() {
		return parcours;
	}

	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}

	public Etudiant() {
		super();
	}

	public Etudiant(String nomEtudiant, int cinEtudiant, Date dateNaissance,Parcours parc) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.cinEtudiant= cinEtudiant;
		this.dateNaissance = dateNaissance;
		parcours=parc;
	}

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public int getCinEtudiant() {
		return cinEtudiant;
	}

	public void setCinEtudiant(int cinEtudiant) {
		this.cinEtudiant = cinEtudiant;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", cinEtudiant=" + cinEtudiant
				+ ", dateNaissance=" + dateNaissance + ", parcours=" + parcours + "]";
	}

	
	
	
}