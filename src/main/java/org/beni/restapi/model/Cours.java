package org.beni.restapi.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCours;
    @Column(length = 50)
    private String libelleCours;
    @Column(length = 50)
    private String codeCours;

    public Cours(long idCours, String libelleCours, String codeCours, Prof prof) {
        this.idCours = idCours;
        this.libelleCours = libelleCours;
        this.codeCours = codeCours;
        this.prof = prof;
    }

    public Cours() {

    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public long getIdCours() {
        return idCours;
    }

    public void setIdCours(long idCours) {
        this.idCours = idCours;
    }

    public String getLibelleCours() {
        return libelleCours;
    }

    public void setLibelleCours(String libelleCours) {
        this.libelleCours = libelleCours;
    }

    public String getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(String codeCours) {
        this.codeCours = codeCours;
    }

    @ManyToOne
    @JoinColumn(name="idProf",nullable = true,foreignKey = @ForeignKey(name = "fk_cours_prof"))
    private Prof prof;

}
