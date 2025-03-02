package org.beni.restapi.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.beni.restapi.dto.EtudiantDto;
import org.beni.restapi.model.Etudiant;


public class EtudiantMapper {
    public static EtudiantDto maptoEtudiantDto(Etudiant etudiant) {
        return  new EtudiantDto(
                etudiant.getIdEtudiant(),
                etudiant.getMatricule(),
                etudiant.getNom(),
                etudiant.getPrenom(),
                etudiant.getEmail(),
                etudiant.getClasse()
        );
    }

    public static Etudiant maptoEtudiantEntity(EtudiantDto etudiantDto) {
        return new Etudiant(
                etudiantDto.getIdEtudiant(),
                etudiantDto.getMatricule(),
                etudiantDto.getNom(),
                etudiantDto.getPrenom(),
                etudiantDto.getEmail(),
                etudiantDto.getClasse()
        );
    }
}
