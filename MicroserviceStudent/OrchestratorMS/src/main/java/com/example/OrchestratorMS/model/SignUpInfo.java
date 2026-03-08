package com.example.OrchestratorMS.model;

import java.time.LocalDateTime;
import java.util.List;

public class SignUpInfo {
	private String nom;
	private String prenom;
	private String email;
	private String etablissement;
	private String filiere;
	private List<String> competences;
	private List<LocalDateTime> disponibilites;
	private String password;
	public SignUpInfo(String nom, String prenom, String email, String etablissement, String filiere,
			List<String> competences, List<LocalDateTime> disponibilites, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.etablissement = etablissement;
		this.filiere = filiere;
		this.competences = competences;
		this.disponibilites = disponibilites;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public List<String> getCompetences() {
		return competences;
	}
	public void setCompetences(List<String> competences) {
		this.competences = competences;
	}
	public List<LocalDateTime> getDisponibilites() {
		return disponibilites;
	}
	public void setDisponibilites(List<LocalDateTime> disponibilites) {
		this.disponibilites = disponibilites;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
