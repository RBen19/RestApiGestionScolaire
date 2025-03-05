package org.beni.restapi.dto;

import org.beni.restapi.model.Classe;
import org.beni.restapi.model.Cours;

public class EmploiDuTempsDto {
    private Long idEmploiDuTemps;
    private Classe classe;
    private Cours cours;

    public EmploiDuTempsDto() {
    }

    public EmploiDuTempsDto(Long idEmploiDuTemps, Classe classe, Cours cours) {
        this.idEmploiDuTemps = idEmploiDuTemps;
        this.classe = classe;
        this.cours = cours;
    }

    public Long getIdEmploiDuTemps() {
        return idEmploiDuTemps;
    }

    public void setIdEmploiDuTemps(Long idEmploiDuTemps) {
        this.idEmploiDuTemps = idEmploiDuTemps;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
