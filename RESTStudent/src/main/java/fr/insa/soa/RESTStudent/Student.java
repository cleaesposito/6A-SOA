package fr.insa.soa.RESTStudent;

import java.time.LocalDateTime;
import java.util.List;

public class Student {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String etablissement;
    private String filiere;
    private List<String> competences;
    private List<LocalDateTime> disponibilites;
    private double noteMoyenne;

    // Constructeur vide
    public Student() {}

    // Getters et setters
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email;}

    public String getEtablissement() {return etablissement;}
    public void setEtablissement(String etablissement) {this.etablissement = etablissement;}

    public String getFiliere() {return filiere;}
    public void setFiliere(String filiere) {this.filiere = filiere;}

    public List<String> getCompetences() {return competences;}
    public void setCompetences(List<String> competences) {this.competences = competences;}

    public List<LocalDateTime> getDisponibilites() {return disponibilites;}
    public void setDisponibilites(List<LocalDateTime> disponibilites) {this.disponibilites = disponibilites;}

    public double getNoteMoyenne() {return noteMoyenne;}
    public void setNoteMoyenne(double noteMoyenne) {this.noteMoyenne = noteMoyenne;}
}