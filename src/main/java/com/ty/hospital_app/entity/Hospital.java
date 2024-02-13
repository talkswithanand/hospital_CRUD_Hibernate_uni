package com.ty.hospital_app.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	private int hospitalId;
	private String hospitalName;
	private String hospitalSpeciality;
	private int noOfBeds;
	private int noOfPatients;
	
	@OneToMany
	private List<Branch> branches;

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalSpeciality() {
		return hospitalSpeciality;
	}

	public void setHospitalSpeciality(String hospitalSpeciality) {
		this.hospitalSpeciality = hospitalSpeciality;
	}


	public int getNoOfPatients() {
		return noOfPatients;
	}

	public void setNoOfPatients(int noOfPatients) {
		this.noOfPatients = noOfPatients;
	}


	public int getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalSpeciality="
				+ hospitalSpeciality + ", noOfBeds=" + noOfBeds + ", noOfPatients=" + noOfPatients + "]";
	}
	
	
}
