package org.beni.restapi.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.beni.restapi.dto.ProfDto;
import org.beni.restapi.model.Prof;


public class ProfMapper {
    public static ProfDto mapToDto(Prof prof) {
        return new ProfDto(
                prof.getIdProf(),
                prof.getNom(),
                prof.getPrenom(),
                prof.getEmail(),
                prof.getMatriculeProf()
        );
    }

    public static Prof mapToProfEntity(ProfDto profDto) {
        return new Prof(
                profDto.getIdProf(),
                profDto.getNom(),
                profDto.getPrenom(),
                profDto.getEmail(),
                profDto.getMatriculeProf()
        );
    }
}
