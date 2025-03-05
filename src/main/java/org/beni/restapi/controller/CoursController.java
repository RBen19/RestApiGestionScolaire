package org.beni.restapi.controller;

import org.beni.restapi.dto.CoursDto;
import org.beni.restapi.services.ICours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/cours")
@CrossOrigin(origins = "http://localhost:4200")
public class CoursController {

    private final ICours coursService;

    @Autowired
    public CoursController(ICours coursService) {
        this.coursService = coursService;
    }

    @PostMapping
    public ResponseEntity<CoursDto> createCours(@RequestBody CoursDto coursDto) {
        CoursDto c = coursService.createCours(coursDto);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CoursDto>> getAllCours() {
        List<CoursDto> coursDtoList = coursService.getAllCOurs();
        return new ResponseEntity<>(coursDtoList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CoursDto> getCoursById(@PathVariable long id) {
        CoursDto coursDto = coursService.getCoursById(id);
        if (coursDto != null) {
            return new ResponseEntity<>(coursDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCours(@PathVariable long id) {
        boolean deleted = coursService.deleteCours(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<CoursDto> updateCours(@RequestBody CoursDto coursDto) {
        CoursDto c = coursService.updateCours(coursDto);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
