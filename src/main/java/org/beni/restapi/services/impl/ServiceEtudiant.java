package org.beni.restapi.services.impl;

import jakarta.transaction.Transactional;
import org.beni.restapi.dto.EtudiantDto;
import org.beni.restapi.mapper.EtudiantMapper;
import org.beni.restapi.model.Classe;
import org.beni.restapi.model.Etudiant;
import org.beni.restapi.repository.ClasseRepository;
import org.beni.restapi.repository.EtudiantRepository;
import org.beni.restapi.services.IEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceEtudiant implements IEtudiant {
    @Autowired
    public ServiceEtudiant(EtudiantRepository etudiantRepository, ClasseRepository classeRepository) {
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
    }

    private EtudiantRepository etudiantRepository;
    private ClasseRepository classeRepository;

    @Override
    @Transactional
    public EtudiantDto createEtudiant(EtudiantDto etudiantDto) {
        Etudiant e = EtudiantMapper.maptoEtudiantEntity(etudiantDto);
        e.setNom(etudiantDto.getNom());
        e.setPrenom(etudiantDto.getPrenom());
        e.setEmail(etudiantDto.getEmail());
        e.setMatricule(etudiantDto.getMatricule());
        Optional<Classe> classe = classeRepository.findById(etudiantDto.getClasse().getIdClasse());
        if (classe.isPresent()) {
            e.setClasse(classe.get());
        }
// e.setClasse(classe);
        etudiantRepository.saveAndFlush(e);
        etudiantRepository.flush();
        return EtudiantMapper.maptoEtudiantDto(e);
    }

    @Override
    public EtudiantDto getEtudiantById(Long id) {
        Optional<Etudiant> e = etudiantRepository.findById(id);
        return e.map(EtudiantMapper::maptoEtudiantDto).orElse(null);
    }

    @Override
    public List<EtudiantDto> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return etudiants.stream()
                .map(EtudiantMapper::maptoEtudiantDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEtudiantById(Long id) {
        boolean delete = false;
        Optional<Etudiant> e = etudiantRepository.findById(id);
        if (e.isPresent()) {
            etudiantRepository.delete(e.get());
            etudiantRepository.flush();
            delete = true;
        }
        return delete;
    }

    @Override
    public EtudiantDto updateEtudiant(EtudiantDto etudiantDto) {
        Optional<Etudiant> e = etudiantRepository.findById(etudiantDto.getIdEtudiant());
        Etudiant etd = null;
        if (e.isPresent()) {
            Etudiant etudiant = EtudiantMapper.maptoEtudiantEntity(etudiantDto);
            etudiant.setNom(etudiantDto.getNom());
            etudiant.setPrenom(etudiantDto.getPrenom());
            etudiant.setEmail(etudiantDto.getEmail());
            etudiant.setMatricule(etudiantDto.getMatricule());
            etd = etudiant;
            etudiantRepository.saveAndFlush(etudiant);
        }
        return EtudiantMapper.maptoEtudiantDto(etd);
    }
}