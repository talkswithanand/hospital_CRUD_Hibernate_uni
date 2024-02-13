package com.ty.hospital_app.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.entity.Branch;
import com.ty.hospital_app.entity.Encounter;

public class BranchDao {
	private static Scanner sc = new Scanner(System.in);
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public static Branch createBranchObject() {
		Branch branch = new Branch();
		
		System.out.println("Enter Branch id");
		branch.setBranchId(sc.nextInt());
		System.out.println("Enter branch name");
		branch.setBranchName(sc.next());
		System.out.println("Enter branch speciality");
		branch.setBranchSpeciality(sc.next());
		System.out.println("Enter no Of doctors");
		branch.setNoOfDoctors(sc.nextInt());
		System.out.println("Enter no of patients");
		branch.setRatings(sc.nextInt());
		
		//persist address & set address
		branch.setAddress(AddressDao.saveAddress());
		
		return branch;
	}

	public static Branch saveBranch() {
		
		entityTransaction.begin();
		
		Branch branch = createBranchObject();
		entityManager.persist(branch);
//		entityTransaction.commit();
		
//		sc.close();
		return branch;
	}
	
	public static Branch findBranch(int branchId) {
		return entityManager.find(Branch.class, branchId) ;
	}
	
	public static Branch updateBranchList(Encounter encounter, int branchId) {
		Branch branch = entityManager.find(Branch.class, branchId);
		branch.getEncounters().add(encounter);
		
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
		
		return branch;
	}
	
}
