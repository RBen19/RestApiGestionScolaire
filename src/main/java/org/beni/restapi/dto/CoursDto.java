package org.beni.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.beni.restapi.model.Prof;


public class CoursDto {
    private long idCours;
    private String libelleCours;
    private String codeCours;
    private Prof prof;

    public CoursDto(long idCours, String libelleCours, String codeCours, Prof prof) {
        this.idCours = idCours;
        this.libelleCours = libelleCours;
        this.codeCours = codeCours;
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

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }
}
