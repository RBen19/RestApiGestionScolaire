package org.beni.restapi.controller;

import org.beni.restapi.dto.ClasseDto;
import org.beni.restapi.services.IClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/classe")
@CrossOrigin(origins = "http://localhost:4200")
public class ClasseController {

    private final IClasse classeService;

    @Autowired
    public ClasseController(IClasse classeService) {
        this.classeService = classeService;
    }

    @PostMapping
    public ResponseEntity<ClasseDto> createClasse(@RequestBody ClasseDto classeDto) {
        System.out.println("ClasseController - createClasse() - classeDto: " + classeDto);
        ClasseDto c = classeService.createClasse(classeDto);
        System.out.println("ClasseController - createClasse() - created ClasseDto: " + c);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClasseDto> getClasse(@PathVariable long id) {
        System.out.println("ClasseController - getClasse() - id: " + id);
        ClasseDto c = classeService.getClasseBYId(id);
        System.out.println("ClasseController - getClasse() - retrieved ClasseDto: " + c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClasseDto>> getAllClasses() {
        System.out.println("ClasseController - getAllClasses()");
        List<ClasseDto> classeList = classeService.getAllClasses();
        System.out.println("ClasseController - getAllClasses() - retrieved list: " + classeList);
        return new ResponseEntity<>(classeList, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable long id) {
        System.out.println("ClasseController - deleteClasse() - id: " + id);
        classeService.deleteClasse(id);
        System.out.println("ClasseController - deleteClasse() - deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateClasse(@RequestBody ClasseDto classeDto) {
        System.out.println("ClasseController - updateClasse() - classeDto: " + classeDto);
        boolean updatedClasse = classeService.updateClasse(classeDto);
        System.out.println("ClasseController - updateClasse() - updated: " + updatedClasse);
        if (updatedClasse) {
            return new ResponseEntity<>(updatedClasse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
