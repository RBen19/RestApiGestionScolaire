package org.beni.restapi.controller;


import org.beni.restapi.dto.EtudiantDto;
import org.beni.restapi.services.impl.ServiceEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/etudiant")
public class EtudiantController {

    @Autowired
    public EtudiantController(ServiceEtudiant serviceEtudiant) {
        this.serviceEtudiant = serviceEtudiant;
    }
    private ServiceEtudiant serviceEtudiant;

    @PostMapping
    public ResponseEntity<EtudiantDto> addClasse(@RequestBody EtudiantDto etudiantDto) {
        EtudiantDto e = serviceEtudiant.createEtudiant(etudiantDto);
        return  new ResponseEntity<>(e, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EtudiantDto> getEtudiantById(@PathVariable Long id) {
        EtudiantDto e = serviceEtudiant.getEtudiantById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EtudiantDto>> getAllEtudiants() {
        List<EtudiantDto> e = serviceEtudiant.getAllEtudiants();
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

}
