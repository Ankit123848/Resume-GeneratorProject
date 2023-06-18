package com.resumegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumegenerator.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

	static void save(String profile) {
		// TODO Auto-generated method stub
		
	}

}