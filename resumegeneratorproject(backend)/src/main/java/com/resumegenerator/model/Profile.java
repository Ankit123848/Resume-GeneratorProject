package com.resumegenerator.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	//private int id;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	private String first_name;
	private String last_name;
	@Id
	private String email;
	private String phone;
	private String designation;
	public Profile(String first_name, String last_name, String email, String phone, String designation) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
