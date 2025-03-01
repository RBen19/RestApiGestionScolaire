package org.beni.restapi.services.impl;

import org.beni.restapi.dto.ClasseDto;
import org.beni.restapi.mapper.ClasseMapper;
import org.beni.restapi.model.Classe;
import org.beni.restapi.repository.ClasseRepository;
import org.beni.restapi.services.IClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceClasse  implements IClasse {
    private final ClasseRepository classeRepository;
    @Autowired
    public ServiceClasse(ClasseRepository classRepository) {
        this.classeRepository = classRepository;
    }

    @Override
    public ClasseDto createClasse(ClasseDto classeDto) {
        Classe c = ClasseMapper.maptoClasseEntity(classeDto);
        c.setCodeClasse(classeDto.getCodeClasse());
        c.setNomClasse(classeDto.getNomClasse());
        classeRepository.save(c);
        return ClasseMapper.maptoClassDto(c);
    }
}
