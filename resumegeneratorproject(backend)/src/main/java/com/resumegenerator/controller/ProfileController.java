package com.resumegenerator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumegenerator.model.Profile;
import com.resumegenerator.repository.ProfileRepository;


@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class ProfileController {
	
	@Autowired
	ProfileRepository profileRepository;

    @GetMapping("/profile")
    public List<Profile> index(){
        return profileRepository.findAll();
    }
    
    @PostMapping("/save-profile")
	public Profile addProfile(@RequestBody Profile profile)
	{
		return profileRepository.save(profile);
	}	
	
	
	@RequestMapping("findAllProfiles")
	public List<Profile>getProfiles(){
		ArrayList<Profile>profile = new ArrayList<>();
		profile.add(new Profile("Ankit", "Arora", "ankitarora@gmail.com", "111-111-1111", "Software Engineer"));
		profile.add(new Profile("Deepika", "Ravuri", "deepikaravuri@gmail.com", "222-222-2222","Software Developer"));
		
		return profile;
	}
	
	

}

