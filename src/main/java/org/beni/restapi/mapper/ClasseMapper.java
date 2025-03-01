package org.beni.restapi.mapper;


import org.beni.restapi.dto.ClasseDto;
import org.beni.restapi.model.Classe;

public class ClasseMapper {

    public static ClasseDto maptoClassDto(Classe classe) {
        return new ClasseDto(
                classe.getIdClasse(),
                classe.getCodeClasse(),
                classe.getNomClasse()
        );
    }

    public static Classe maptoClasseEntity(ClasseDto classeDto) {
        return new Classe(
                classeDto.getIdClasse(),
                classeDto.getCodeClasse(),
                classeDto.getNomClasse()
        );
    }
}
