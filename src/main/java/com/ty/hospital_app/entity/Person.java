package com.ty.hospital_app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private int personId;
	private String visitedDoctor;
	private String diagnosis;
	private int age;
	private int noOfVisits;
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNoOfVisits() {
		return noOfVisits;
	}
	public void setNoOfVisits(int noOfVisits) {
		this.noOfVisits = noOfVisits;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", visitedDoctor=" + visitedDoctor + ", diagnosis=" + diagnosis
				+ ", age=" + age + ", noOfVisits=" + noOfVisits + "]";
	}
	
}
