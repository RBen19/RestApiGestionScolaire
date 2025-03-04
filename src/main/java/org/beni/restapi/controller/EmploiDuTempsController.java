package org.beni.restapi.controller;

import org.beni.restapi.dto.EmploiDuTempsDto;
import org.beni.restapi.services.impl.ServiceEmploiDuTemps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/emploiDuTemps")
public class EmploiDuTempsController {

    @Autowired
    private ServiceEmploiDuTemps serviceEmploiDuTemps;

    public EmploiDuTempsController(ServiceEmploiDuTemps serviceEmploiDuTemps) {
        this.serviceEmploiDuTemps = serviceEmploiDuTemps;
    }

    @PostMapping
    public ResponseEntity<EmploiDuTempsDto> createEmploiDuTemps(@RequestBody EmploiDuTempsDto emploiDuTempsDto) {
        EmploiDuTempsDto e = serviceEmploiDuTemps.createEmploiDuTemps(emploiDuTempsDto);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmploiDuTempsDto> getEmploiDuTempsById(@PathVariable Long id) {
        EmploiDuTempsDto e = serviceEmploiDuTemps.getEmploiDuTempsById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmploiDuTempsDto>> getAllEmploiDuTemps() {
        List<EmploiDuTempsDto> emplois = serviceEmploiDuTemps.getAllEmploiDuTemps();
        return new ResponseEntity<>(emplois, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EmploiDuTempsDto> deleteEmploiDuTemps(@PathVariable Long id) {
        serviceEmploiDuTemps.deleteEmploiDuTemps(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<EmploiDuTempsDto> updateEmploiDuTemps(@RequestBody EmploiDuTempsDto emploiDuTempsDto) {
        EmploiDuTempsDto e = serviceEmploiDuTemps.updateEmploiDuTemps(emploiDuTempsDto);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
}

