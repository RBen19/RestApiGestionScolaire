package org.beni.restapi.services;

import org.beni.restapi.dto.EmploiDuTempsDto;

import java.util.List;

public interface IEmploiDuTemps {
    EmploiDuTempsDto createEmploiDuTemps(EmploiDuTempsDto emploiDuTempsDto);
    EmploiDuTempsDto getEmploiDuTempsById(Long id);
    List<EmploiDuTempsDto> getAllEmploiDuTemps();
    boolean deleteEmploiDuTemps(Long id);
    EmploiDuTempsDto updateEmploiDuTemps(EmploiDuTempsDto emploiDuTempsDto);
}
