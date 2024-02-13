package com.ty.hospital_app.helper;

import java.util.Scanner;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dao.HospitalDao;
import com.ty.hospital_app.dao.MedOrdersDao;
import com.ty.hospital_app.dao.PersonDao;

public class HelperClass {

	private static Scanner sc = new Scanner(System.in);

	public static int initials() {
		System.out.println("Enter\n1. Save Branch data\n2. Save Encounter data\n3. Save MedOrder data\n4. Exit");
		int choice = sc.nextInt();
		return choice;
	}

	public static void branchOperation() {
		// save branch if hospitalId exist, else register id then save branch

		System.out.println("Enter Hospital Id");
		int hospitalId = sc.nextInt();
		if (HospitalDao.findHospital(hospitalId) != null) {
			HospitalDao.updateHospitalList(BranchDao.saveBranch(), hospitalId);
		} else {
			HospitalDao.saveHospital(hospitalId);
		}
		System.out.println("Branch data saved successfully");
	}

	public static void encounterOperation() {
		System.out.println("Enter Branch Id & person Id");
		int branchId = sc.nextInt();
		int personId = sc.nextInt();
		if (BranchDao.findBranch(branchId) != null) {
			if (PersonDao.findPerson(personId) != null) {
				BranchDao.updateBranchList(EncounterDao.saveEncounter(personId), branchId);
				System.out.println("Encounter data saved successfully");
			} else {
				System.out.println("Register Person!!");
				PersonDao.savePerson();
				System.out.println("Person saved successfully");
			}
		} else {
			System.out.println("Branch does not exist for " + branchId);
		}
	}

	public static void medOrdersOperation() {
		System.out.println("Enter Encounter Id");
		int encounterId = sc.nextInt();
		if (EncounterDao.findEncounter(encounterId) != null) {
			EncounterDao.updateEncounterList(MedOrdersDao.saveMedOrders(), encounterId);
			System.out.println("MedOrder data saved successfully");
		} else {
			System.out.println("Encounter does not exist for " + encounterId);
		}
	}
}
