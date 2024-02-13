package com.ty.hospital_app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {

	@Id
	private int encounterId;
	private String doctorName;
	private String diagnosis;
	private String admitDate;
	private int noOfTests;
	
	@OneToMany
	private List<MedOrders> medOrders;
	
	@ManyToOne
	private Person person;

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}

	public int getNoOfTests() {
		return noOfTests;
	}

	public void setNoOfTests(int noOfTests) {
		this.noOfTests = noOfTests;
	}

	public List<MedOrders> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Encounter [encounterId=" + encounterId + ", doctorName=" + doctorName + ", diagnosis=" + diagnosis
				+ ", admitDate=" + admitDate + ", noOfTests=" + noOfTests + "]";
	}
	
	
}
