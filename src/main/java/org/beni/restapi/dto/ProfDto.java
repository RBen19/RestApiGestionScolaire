package org.beni.restapi.dto;

public class ProfDto {
    private Long idProf;
    private String nom;
    private String prenom;
    private String email;
    private String matriculeProf;

    public ProfDto(Long idProf, String prenom, String nom, String email, String matriculeProf) {}

    public ProfDto(String nom, String prenom, String email, String matriculeProf) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.matriculeProf = matriculeProf;

    }

    public Long getIdProf() {
        return idProf;
    }

    public void setIdProf(Long idProf) {
        this.idProf = idProf;
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

    public String getMatriculeProf() {
        return matriculeProf;
    }

    public void setMatriculeProf(String matriculeProf) {
        this.matriculeProf = matriculeProf;
    }
}
