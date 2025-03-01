package org.beni.restapi.controller;

import lombok.AllArgsConstructor;
import org.beni.restapi.dto.ClasseDto;
import org.beni.restapi.services.impl.ServiceClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<ClasseDto>> getAllClasses() {
        List<ClasseDto> classeList = classeService.getAllClasses();
        return new ResponseEntity<>(classeList, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ClasseDto> deleteClasse(@PathVariable long id) {
        classeService.deleteClasse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<ClasseDto> updateClasse(@RequestBody ClasseDto classeDto) {
         classeService.updateClasse(classeDto);
       return new ResponseEntity<>(classeDto, HttpStatusCode.valueOf(203));
    }
}
