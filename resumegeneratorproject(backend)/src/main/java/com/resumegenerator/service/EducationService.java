package com.resumegenerator.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumegenerator.model.Education;
import com.resumegenerator.repository.EducationRepository;
@Service
@Transactional
public class EducationService {

    @Autowired
    private EducationRepository repo;
     
    public List<Education> listAll() {
        return repo.findAll();
    }
     
    public void save(Education education) {
        repo.save(education);
    }
     
    public Education get(Integer education_id) {
        return repo.findById(education_id).get();
    }
     
    public void delete(Integer education_id) {
        repo.deleteById(education_id);
    }
}