package com.resumegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resumegenerator.model.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {

	static void save(String education) {
		// TODO Auto-generated method stub
		
	}

}
