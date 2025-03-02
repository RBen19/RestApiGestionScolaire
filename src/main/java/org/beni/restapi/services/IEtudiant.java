package org.beni.restapi.services;

import org.beni.restapi.dto.EtudiantDto;

import java.util.List;

public interface IEtudiant {
    EtudiantDto createEtudiant(EtudiantDto etudiantDto);
    EtudiantDto getEtudiantById(Long id);
    List<EtudiantDto> getAllEtudiants();
    boolean deleteEtudiantById(Long id);
    EtudiantDto updateEtudiant(EtudiantDto etudiantDto);
}
