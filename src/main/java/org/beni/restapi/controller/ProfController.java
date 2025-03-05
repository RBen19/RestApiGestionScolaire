package org.beni.restapi.controller;

import org.beni.restapi.dto.ProfDto;
import org.beni.restapi.services.IProf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/prof")
@CrossOrigin(origins = "http://localhost:4200")

public class ProfController {

    private final IProf profService;

    @Autowired
    public ProfController(IProf profService) {
        this.profService = profService;
    }

    @PostMapping
    public ResponseEntity<ProfDto> createProf(@RequestBody ProfDto profDto) {
        ProfDto p = profService.createProf(profDto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfDto> getProfById(@PathVariable Long id) {
        ProfDto p = profService.getProfById(id);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ProfDto>> getAllProf() {
        List<ProfDto> profs = profService.getAllProf();
        return new ResponseEntity<>(profs, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProf(@PathVariable Long id) {
        boolean deleted = profService.deleteProfById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<ProfDto> updateProf(@RequestBody ProfDto profDto) {
        ProfDto p = profService.updateProf(profDto);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
