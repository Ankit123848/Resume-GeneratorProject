package com.resumegenerator.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumegenerator.model.Experience;
import com.resumegenerator.service.ExperienceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping(value="/exp")  
public class ExperienceController {
 
    @Autowired
    private ExperienceService service;
     
    @GetMapping("/experience")
    public List<Experience> list() {
        return service.listAll();
    }
   
     
    @PostMapping("/save-experience")
    public void add(@RequestBody Experience experience) {
        service.save(experience);
    }
    @GetMapping("/experience/{id}")
    public ResponseEntity<Experience> get(@PathVariable Integer experience_id) {
        try {
            Experience experience = service.get(experience_id);
            return new ResponseEntity<Experience>(experience, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
        }      
    }
     
    
    @PutMapping("/experience/{id}")
    public ResponseEntity<?> update(@RequestBody Experience experience, @PathVariable Integer experience_id) {
        try {
            Experience existExperience = service.get(experience_id);
            service.save(experience);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    @DeleteMapping("/experience/{id}")
    public void delete(@PathVariable Integer experience_id) {
        service.delete(experience_id);
    }
}

