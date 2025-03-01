package org.beni.restapi.controller;

import lombok.AllArgsConstructor;
import org.beni.restapi.dto.ClasseDto;
import org.beni.restapi.services.impl.ServiceClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestion/classe")
public class ClasseController {

    @Autowired
   public ClasseController(ServiceClasse serviceClasse) {
        this.classeService = serviceClasse;
    }
    private ServiceClasse classeService;

    @PostMapping
    public ResponseEntity<ClasseDto> createClasse(@RequestBody ClasseDto classeDto) {

       ClasseDto c =  classeService.createClasse(classeDto);
       return  new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ClasseDto> getClasse(@PathVariable long id) {
       ClasseDto c =  classeService.getClasseBYId(id);
       return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
