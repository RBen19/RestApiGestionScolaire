package org.beni.restapi.mapper;

import org.beni.restapi.dto.CoursDto;
import org.beni.restapi.model.Cours;

public class CoursMapper {
    public static CoursDto mapCoursToDto(Cours cours) {
        return  new CoursDto(
                cours.getIdCours(),
                cours.getLibelleCours(),
                cours.getCodeCours(),
                cours.getProf()
        );
    }

    public static Cours mapDtoToCoursEntity(CoursDto dto) {
        return  new Cours(
                dto.getIdCours(),
                dto.getLibelleCours(),
                dto.getCodeCours(),
                dto.getProf()
        );
    }
}
