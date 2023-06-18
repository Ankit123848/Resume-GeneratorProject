package com.resumegenerator.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int experience_id;
    private String experience_company;
    private String experience_designation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate experience_startdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate experience_enddate;
    public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}
    public int getExperience_id() {
		return experience_id;
	}
	public void setExperience_id(int experience_id) {
		this.experience_id = experience_id;
	}
	public String getExperience_company() {
		return experience_company;
	}
	public void setExperience_company(String experience_company) {
		this.experience_company = experience_company;
	}
	public String getExperience_designation() {
		return experience_designation;
	}
	public void setExperience_designation(String experience_designation) {
		this.experience_designation = experience_designation;
	}
	public LocalDate getExperience_startdate() {
		return experience_startdate;
	}
	public void setExperience_startdate(LocalDate experience_startdate) {
		this.experience_startdate = experience_startdate;
	}
	public LocalDate getExperience_enddate() {
		return experience_enddate;
	}
	public void setExperience_enddate(LocalDate experience_enddate) {
		this.experience_enddate = experience_enddate;
	}
	public Experience(int experience_id, String experience_company, String experience_designation,
			LocalDate experience_startdate, LocalDate experience_enddate) {
		super();
		this.experience_id = experience_id;
		this.experience_company = experience_company;
		this.experience_designation = experience_designation;
		this.experience_startdate = experience_startdate;
		this.experience_enddate = experience_enddate;
	}
	
}
