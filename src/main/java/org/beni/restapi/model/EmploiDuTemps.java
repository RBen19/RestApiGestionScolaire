package org.beni.restapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_emploi_du_temps")
public class EmploiDuTemps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploiDuTemps;

    @ManyToOne
    @JoinColumn(name = "idClasse", nullable = false, foreignKey = @ForeignKey(name = "fk_emploi_du_temps_classe"))
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "idCours", nullable = false, foreignKey = @ForeignKey(name = "fk_emploi_du_temps_cours"))
    private Cours cours;

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
