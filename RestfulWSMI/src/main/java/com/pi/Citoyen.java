package com.pi;
//CECI REPRESENTE LE MODEL DE MON MVC CHAQUE TABLE DE LA BD A SON MODEL: CONSTRUIT LA TABLE DANS LA BD
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Citoyen implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	@Column(length = 40)
	private String nom;
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dateNaissance;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	

}
