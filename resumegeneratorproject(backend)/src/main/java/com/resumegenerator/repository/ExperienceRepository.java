package com.resumegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resumegenerator.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

	static void save(String experience) {
		// TODO Auto-generated method stub
		
	}

}
