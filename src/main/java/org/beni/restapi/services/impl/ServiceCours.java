package org.beni.restapi.services.impl;

import org.beni.restapi.dto.CoursDto;
import org.beni.restapi.mapper.CoursMapper;
import org.beni.restapi.model.Cours;
import org.beni.restapi.model.Prof;
import org.beni.restapi.repository.CoursRepository;
import org.beni.restapi.repository.ProfRepository;
import org.beni.restapi.services.ICours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceCours implements ICours {

    public ServiceCours(CoursRepository coursRepository,ProfRepository profRepository) {
        this.coursRepository = coursRepository;
        this.profRepository = profRepository;
    }
    @Autowired
    private CoursRepository coursRepository;
    private ProfRepository profRepository;

    @Override
    public CoursDto createCours(CoursDto coursDto) {
      Cours cours = CoursMapper.mapDtoToCoursEntity(coursDto);
      cours.setCodeCours(coursDto.getCodeCours());
      cours.setLibelleCours(coursDto.getLibelleCours());
      Optional<Prof> p = profRepository.findById(cours.getProf().getIdProf());
      if(p.isPresent()) {
          cours.setProf(p.get());
      }
     Cours savedCours =  coursRepository.saveAndFlush(cours);
      return CoursMapper.mapCoursToDto(savedCours);
    }

    @Override
    public CoursDto getCoursById(long idCours) {
        Optional<Cours> cours = coursRepository.findById(idCours);
        return CoursMapper.mapCoursToDto(cours.get());
    }

    @Override
    public List<CoursDto> getAllCOurs() {
        List<Cours> coursList = coursRepository.findAll();
     return   coursList.stream()
                .map(CoursMapper::mapCoursToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteCours(long idCours) {
        boolean deleted = false;
        coursRepository.deleteById(idCours);
        deleted = true;
        return deleted;
    }

    @Override
    public CoursDto updateCours(CoursDto coursDto) {
        Cours cours = CoursMapper.mapDtoToCoursEntity(coursDto);
        cours.setCodeCours(coursDto.getCodeCours());
        cours.setLibelleCours(coursDto.getLibelleCours());
      Optional<Prof> p =   profRepository.findById(cours.getProf().getIdProf());
      if(p.isPresent()) {
          cours.setProf(p.get());
      }
      Cours savedCours = coursRepository.saveAndFlush(cours);
      return CoursMapper.mapCoursToDto(savedCours);


    }
}
