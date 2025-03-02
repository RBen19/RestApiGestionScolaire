package org.beni.restapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClasse;
    @Column(length = 50)
    private String codeClasse;
    @Column(length = 50)
    private String nomClasse;


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
