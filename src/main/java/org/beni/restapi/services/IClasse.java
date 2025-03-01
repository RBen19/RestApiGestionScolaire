package org.beni.restapi.services;

import org.beni.restapi.dto.ClasseDto;

import java.util.List;

public interface IClasse {
    ClasseDto createClasse(ClasseDto classeDto);
    ClasseDto getClasseBYId(long idClasse);
    List<ClasseDto> getAllClasses();
}
