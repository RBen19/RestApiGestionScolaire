package org.beni.restapi.services.impl;

import org.beni.restapi.dto.ClasseDto;
import org.beni.restapi.mapper.ClasseMapper;
import org.beni.restapi.model.Classe;
import org.beni.restapi.repository.ClasseRepository;
import org.beni.restapi.services.IClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public ClasseDto getClasseBYId(long idClasse) {
           Optional<Classe> c  =   classeRepository.findById(idClasse);
           return c.map(ClasseMapper::maptoClassDto).orElse(null);
    }

    @Override
    public List<ClasseDto> getAllClasses() {
       List<Classe> classeList = classeRepository.findAll();
        return classeList.stream().map(ClasseMapper::maptoClassDto).collect(Collectors.toList());
    }

    @Override
    public boolean deleteClasse(long idClasse) {
        boolean delete = false;
        Classe c = classeRepository.findById(idClasse).get();
        classeRepository.delete(c);
        delete = true;
        return delete;
    }

    @Override
    public boolean updateClasse(ClasseDto classeDto) {
        boolean update = false;
        Optional<Classe> c = classeRepository.findById(classeDto.getIdClasse());
        if (c.isPresent()) {
            Classe classe = ClasseMapper.maptoClasseEntity(classeDto);
            classe.setCodeClasse(classeDto.getCodeClasse());
            classe.setNomClasse(classeDto.getNomClasse());
            classeRepository.save(classe);
            update = true;
        }
        return update;
    }
}
