package org.beni.restapi.controller;

import org.beni.restapi.dto.CoursDto;
import org.beni.restapi.services.impl.ServiceCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/cours")
public class CoursController {
    @Autowired
    private ServiceCours serviceCours;
    public CoursController(ServiceCours serviceCours) {
        this.serviceCours = serviceCours;
    }
    @PostMapping
    public ResponseEntity<CoursDto> createCours(@RequestBody CoursDto coursDto) {
       CoursDto c =  serviceCours.createCours(coursDto);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<CoursDto>> getAllCours() {
        List<CoursDto> coursDtoList = serviceCours.getAllCOurs();
        return new ResponseEntity<>(coursDtoList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<CoursDto> getCoursById(@PathVariable long id) {
        CoursDto coursDto = serviceCours.getCoursById(id);
        return new ResponseEntity<>(coursDto, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<CoursDto> deleteCours(@PathVariable long id) {
         boolean delete =  serviceCours.deleteCours(id);
         if(delete)
         {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping
    public ResponseEntity<CoursDto> updateCours(@RequestBody CoursDto coursDto) {
        CoursDto c =  serviceCours.updateCours(coursDto);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
