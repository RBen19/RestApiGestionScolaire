package org.beni.restapi.services.impl;

import org.beni.restapi.dto.EmploiDuTempsDto;
import org.beni.restapi.mapper.EmploiDuTempsMapper;
import org.beni.restapi.model.EmploiDuTemps;
import org.beni.restapi.repository.EmploiDuTempsRepository;
import org.beni.restapi.services.IEmploiDuTemps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceEmploiDuTemps implements IEmploiDuTemps {

    private final EmploiDuTempsRepository emploiDuTempsRepository;

    @Autowired
    public ServiceEmploiDuTemps(EmploiDuTempsRepository emploiDuTempsRepository) {
        this.emploiDuTempsRepository = emploiDuTempsRepository;
    }

    @Override
    public EmploiDuTempsDto createEmploiDuTemps(EmploiDuTempsDto emploiDuTempsDto) {
        EmploiDuTemps emploiDuTemps = EmploiDuTempsMapper.mapToEntity(emploiDuTempsDto);
        EmploiDuTemps savedEmploiDuTemps = emploiDuTempsRepository.saveAndFlush(emploiDuTemps);
        return EmploiDuTempsMapper.mapToDto(savedEmploiDuTemps);
    }

    @Override
    public EmploiDuTempsDto getEmploiDuTempsById(Long id) {
        Optional<EmploiDuTemps> emploiDuTemps = emploiDuTempsRepository.findById(id);
        return emploiDuTemps.map(EmploiDuTempsMapper::mapToDto).orElse(null);
    }

    @Override
    public List<EmploiDuTempsDto> getAllEmploiDuTemps() {
        List<EmploiDuTemps> emploiDuTempsList = emploiDuTempsRepository.findAll();
        return emploiDuTempsList.stream()
                .map(EmploiDuTempsMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEmploiDuTemps(Long id) {
        if (emploiDuTempsRepository.existsById(id)) {
            emploiDuTempsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public EmploiDuTempsDto updateEmploiDuTemps(EmploiDuTempsDto emploiDuTempsDto) {
        Optional<EmploiDuTemps> existingEmploiDuTemps = emploiDuTempsRepository.findById(emploiDuTempsDto.getIdEmploiDuTemps());
        if (existingEmploiDuTemps.isPresent()) {
            EmploiDuTemps emploiDuTemps = EmploiDuTempsMapper.mapToEntity(emploiDuTempsDto);
            EmploiDuTemps updatedEmploiDuTemps = emploiDuTempsRepository.saveAndFlush(emploiDuTemps);
            return EmploiDuTempsMapper.mapToDto(updatedEmploiDuTemps);
        }
        return null;
    }
}
