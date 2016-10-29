package com.pf.doctor.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor {
	private String firstName;
	private String lastName;
	private String city;
	private int	zipCode;
	private int age;
	private int phNbr;
	private int rating;
	private String speciality;
	private List<String> lang= new ArrayList<String>();
	private String gender;
	//private int rank;
	
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(String firstName, String lastName, String city, String gender, 
			String speciality, int zipCode, int age, int phNbr, int rating)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.city=city;
		this.zipCode=zipCode;
		this.age=age;
		this.phNbr=phNbr;
		this.rating=rating;
		this.gender=gender;
		this.speciality=speciality;
	}
	
	//Getter and Setter Methods
	
	public String getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getLang() {
		return lang;
	}
	
	public void setLang(List<String> lang) {
		this.lang = lang;
	}
	
	public void addLang(String l){
		lang.add(l);
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhNbr() {
		return phNbr;
	}

	public void setPhNbr(int phNbr) {
		this.phNbr = phNbr;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	
	
}
