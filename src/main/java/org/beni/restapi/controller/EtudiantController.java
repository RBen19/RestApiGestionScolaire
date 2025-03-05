package org.beni.restapi.controller;

import org.beni.restapi.dto.EtudiantDto;
import org.beni.restapi.services.IEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/etudiant")
@CrossOrigin(origins = "http://localhost:4200")

public class EtudiantController {

    private final IEtudiant etudiantService;

    @Autowired
    public EtudiantController(IEtudiant etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping
    public ResponseEntity<EtudiantDto> addEtudiant(@RequestBody EtudiantDto etudiantDto) {
        EtudiantDto e = etudiantService.createEtudiant(etudiantDto);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<EtudiantDto>> getAllEtudiants() {
        List<EtudiantDto> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEtudiantById(@PathVariable Long id) {
        boolean deleted = etudiantService.deleteEtudiantById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<EtudiantDto> updateEtudiant(@RequestBody EtudiantDto etudiantDto) {
        EtudiantDto e = etudiantService.updateEtudiant(etudiantDto);
        if (e != null) {
            return new ResponseEntity<>(e, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
