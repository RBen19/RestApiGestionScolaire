package org.beni.restapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
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


}
