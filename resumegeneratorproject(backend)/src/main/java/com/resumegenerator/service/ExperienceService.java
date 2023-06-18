package com.resumegenerator.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumegenerator.model.Experience;
import com.resumegenerator.repository.ExperienceRepository;

@Service
@Transactional
public class ExperienceService {
 
    @Autowired
    private ExperienceRepository repo;
     
    public List<Experience> listAll() {
        return repo.findAll();
    }
     
    public void save(Experience experience) {
        repo.save(experience);
    }
     
    public Experience get(Integer experience_id) {
        return repo.findById(experience_id).get();
    }
     
    public void delete(Integer experience_id) {
        repo.deleteById(experience_id);
    }
}
