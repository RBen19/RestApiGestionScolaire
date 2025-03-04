package org.beni.restapi.mapper;

import org.beni.restapi.dto.EmploiDuTempsDto;
import org.beni.restapi.model.EmploiDuTemps;

public class EmploiDuTempsMapper {

    public static EmploiDuTempsDto mapToDto(EmploiDuTemps emploiDuTemps) {
        return new EmploiDuTempsDto(
                emploiDuTemps.getIdEmploiDuTemps(),
                emploiDuTemps.getClasse(),
                emploiDuTemps.getCours()
        );
    }

    public static EmploiDuTemps mapToEntity(EmploiDuTempsDto emploiDuTempsDto) {
        EmploiDuTemps emploiDuTemps = new EmploiDuTemps();
        emploiDuTemps.setIdEmploiDuTemps(emploiDuTempsDto.getIdEmploiDuTemps());
        emploiDuTemps.setClasse(emploiDuTempsDto.getClasse());
        emploiDuTemps.setCours(emploiDuTempsDto.getCours());
        return emploiDuTemps;
    }
}
