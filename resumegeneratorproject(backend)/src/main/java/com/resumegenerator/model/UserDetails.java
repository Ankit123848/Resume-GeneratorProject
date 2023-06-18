package com.resumegenerator.model;

import org.springframework.stereotype.Component;


public class UserDetails {
	public Education education;
	public Profile profile;
	public Experience experience;
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Experience getExperience() {
		return experience;
	}
	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
	
}
