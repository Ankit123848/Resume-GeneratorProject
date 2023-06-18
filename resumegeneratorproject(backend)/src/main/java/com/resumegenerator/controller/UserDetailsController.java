package com.resumegenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumegenerator.model.UserDetails;
import com.resumegenerator.repository.EducationRepository;
import com.resumegenerator.repository.ExperienceRepository;
import com.resumegenerator.repository.ProfileRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserDetailsController {
	
	
	@Autowired
	private ProfileRepository profilerepo;
	
	@Autowired
	private EducationRepository edurepo;
	
	@Autowired
	private ExperienceRepository exprepo;
	
	
	
	@PostMapping("/save")
	public void add(@RequestBody UserDetails userdetails) {
//		userdetails.getprofile();
//		userdetails.getEducation();
//		userdetails.getExperience();
        profilerepo.save(userdetails.getProfile());
        edurepo.save(userdetails.getEducation());
        exprepo.save(userdetails.getExperience());
    }

}
