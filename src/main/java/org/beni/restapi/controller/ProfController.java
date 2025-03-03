package org.beni.restapi.controller;

import org.beni.restapi.dto.ProfDto;
import org.beni.restapi.mapper.ProfMapper;
import org.beni.restapi.services.impl.ServiceProf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/prof")
public class ProfController {
    public ProfController(ServiceProf serviceProf) {
        this.serviceProf = serviceProf;
    }
    @Autowired
    private ServiceProf serviceProf;

    @PostMapping
    public ResponseEntity<ProfDto> createProf(@RequestBody ProfDto profDto) {
      ProfDto p =   serviceProf.createProf(profDto);
        return  new ResponseEntity<>(p, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProfDto> getProfById(@PathVariable Long id) {
       ProfDto p =  serviceProf.getProfById(id);
       return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<ProfDto>> getAllProf() {
        List<ProfDto> profs = serviceProf.getAllProf();
        return new ResponseEntity<>(profs, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ProfDto> deleteProf(@PathVariable Long id) {
        boolean deleted = serviceProf.deleteProfById(id);
        return new   ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<ProfDto> updateProf(@RequestBody ProfDto profDto) {
        ProfDto p =   serviceProf.updateProf(profDto);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
