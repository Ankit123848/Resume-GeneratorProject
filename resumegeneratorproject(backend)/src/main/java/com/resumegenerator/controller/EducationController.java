package com.resumegenerator.controller;

import java.util.ArrayList;
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

import com.resumegenerator.model.Education;
import com.resumegenerator.service.EducationService;
    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api")  
    public class EducationController {
     
        @Autowired
        private EducationService service;
         
        @GetMapping("/education")
        public List<Education> list() {
            return service.listAll();
        }
       
        @PostMapping("/save-education")
        public void add(@RequestBody Education education) {
//            service.save(education);
        	service.save(education);
        }
        @GetMapping("/education/{id}")
        public ResponseEntity<Education> get(@PathVariable Integer education_id) {
            try {
                Education education = service.get(education_id);
                return new ResponseEntity<Education>(education, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<Education>(HttpStatus.NOT_FOUND);
            }      
        }
         
        
        @PutMapping("/education/{id}")
        public ResponseEntity<?> update(@RequestBody Education education, @PathVariable Integer education_id) {
            try {
                Education existEducation = service.get(education_id);
                service.save(education);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }      
        }
        @DeleteMapping("/education/{id}")
        public void delete(@PathVariable Integer education_id) {
            service.delete(education_id);
        }
        
    }
