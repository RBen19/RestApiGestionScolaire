package org.beni.restapi.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ClasseDto {

    private long idClasse;
    private String codeClasse;
    private String nomClasse;

    public ClasseDto(long idClasse, String codeClasse, String nomClasse) {
        this.idClasse = idClasse;
        this.codeClasse = codeClasse;
        this.nomClasse = nomClasse;
    }

    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    public String getCodeClasse() {
        return codeClasse;
    }

    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
}
