package org.beni.restapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.beni.restapi.model.Classe;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtudiantDto {
    private long idEtudiant;
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private Classe classe;

}
