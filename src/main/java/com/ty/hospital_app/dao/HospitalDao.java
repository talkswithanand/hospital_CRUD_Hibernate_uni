package com.ty.hospital_app.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.entity.Branch;
import com.ty.hospital_app.entity.Hospital;

public class HospitalDao {
	private static Scanner sc = new Scanner(System.in);

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static Hospital createHospitalObject(int HospitalId) {
		Hospital hospital = new Hospital();

//		System.out.println("Enter hospital id");
		hospital.setHospitalId(HospitalId);
		System.out.println("Enter hospital name");
		hospital.setHospitalName(sc.next());
		System.out.println("Enter hospital speciality");
		hospital.setHospitalSpeciality(sc.next());
		System.out.println("Enter no Of Beds available");
		hospital.setNoOfBeds(sc.nextInt());
		System.out.println("Enter no of patients");
		hospital.setNoOfPatients(sc.nextInt());

		// persist branch & set branches
		Branch branch = BranchDao.saveBranch();
		List<Branch> branches = new ArrayList<Branch>();
		branches.add(branch);
		hospital.setBranches(branches);

		return hospital;
	}

	public static Hospital saveHospital(int hospitalId) {
		Hospital hospital = createHospitalObject(hospitalId);

		entityTransaction.begin();

		entityManager.persist(hospital);
		BranchDao.entityTransaction.commit();
		entityTransaction.commit();

//		sc.close();
		return hospital;
	}

	public static Hospital findHospital(int hospitalId) {
		return entityManager.find(Hospital.class, hospitalId);
	}
	
	public static Hospital updateHospitalList(Branch branch, int hospitalId) {
		Hospital hospital = entityManager.find(Hospital.class, hospitalId);
		hospital.getBranches().add(branch);
		
		entityTransaction.begin();
		entityManager.merge(hospital);
		entityTransaction.commit();
		
		return hospital;
	}

}
