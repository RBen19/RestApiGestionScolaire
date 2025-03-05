package org.beni.restapi.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "tb_etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    @Column(length = 100)
    private String matricule;
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenom;
    @Column(length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idClasse",nullable = true,foreignKey = @ForeignKey(name = "fk_etudiant_classe"))
    private Classe classe;

    public Etudiant(long idEtudiant, String matricule, String nom, String prenom, String email, Classe classe) {
        this.idEtudiant = idEtudiant;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.classe = classe;
    }



    public Etudiant() {
    }

    public long getIdEtudiant() {
        return idEtudiant;
    }
    public void setIdEtudiant(long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

}
