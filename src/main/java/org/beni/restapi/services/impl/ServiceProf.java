package org.beni.restapi.services.impl;

import org.beni.restapi.dto.ProfDto;
import org.beni.restapi.mapper.ProfMapper;
import org.beni.restapi.model.Prof;
import org.beni.restapi.repository.ProfRepository;
import org.beni.restapi.services.IProf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceProf  implements IProf {
    @Autowired
    public ServiceProf(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }
    private ProfRepository profRepository;

    @Override
    public ProfDto createProf(ProfDto profDto) {
        Prof prof = ProfMapper.mapToProfEntity(profDto);
        prof.setNom(profDto.getNom());
        prof.setPrenom(profDto.getPrenom());
        prof.setEmail(profDto.getEmail());
        prof.setMatriculeProf(profDto.getMatriculeProf());
        profRepository.saveAndFlush(prof);
        return ProfMapper.mapToDto(prof);
    }

    @Override
    public ProfDto getProfById(Long id) {
        Optional<Prof> prof = profRepository.findById(id);
      return prof.map(ProfMapper::mapToDto).orElse(null);
    }

    @Override
    public List<ProfDto> getAllProf() {
        List<Prof> profs = profRepository.findAll();
       return profs.stream()
                .map(ProfMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteProfById(Long id) {
        boolean deleted = false;
        profRepository.deleteById(id);
        deleted = true;
        return deleted;
    }

    @Override
    public ProfDto updateProf(ProfDto profDto) {
        Optional<Prof> p = profRepository.findById(profDto.getIdProf());
        ProfDto pdto = null;
        if (p.isPresent()) {
            Prof prof = ProfMapper.mapToProfEntity(profDto);
            prof.setNom(profDto.getNom());
            prof.setPrenom(profDto.getPrenom());
            prof.setEmail(profDto.getEmail());
            prof.setMatriculeProf(profDto.getMatriculeProf());
            pdto = ProfMapper.mapToDto(prof);
            profRepository.saveAndFlush(prof);
        }
        return pdto;
    }
}
