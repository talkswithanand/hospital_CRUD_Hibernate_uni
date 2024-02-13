package com.ty.hospital_app.dao;

import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.entity.Encounter;
import com.ty.hospital_app.entity.MedOrders;
import com.ty.hospital_app.entity.Person;

public class EncounterDao {
	
	private static Scanner sc = new Scanner(System.in);

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static Encounter createEncounterObject(int personId) {
		Encounter encounter = new Encounter();

		System.out.println("Enter encounter id");
		encounter.setEncounterId(sc.nextInt());
		System.out.println("Enter admit date");
		encounter.setAdmitDate(sc.next());
		System.out.println("Enter diagnosis");
		encounter.setDiagnosis(sc.next());
		System.out.println("Enter doctor name");
		encounter.setDoctorName(sc.next());
		System.out.println("Enter no of tests");
		encounter.setNoOfTests(sc.nextInt());

		// Find person & set person
		Person person = PersonDao.findPerson(personId);
		encounter.setPerson(person);

		return encounter;
	}

	public static Encounter saveEncounter(int personId) {
		Encounter encounter = createEncounterObject(personId);

		entityTransaction.begin();

		entityManager.persist(encounter);

		entityTransaction.commit();

//		sc.close();
		return encounter;
	}

	public static Encounter findEncounter(int encounterId) {
		return entityManager.find(Encounter.class, encounterId);
	}
	
	public static Encounter updateEncounterList(MedOrders medOrders, int encounterId) {
		Encounter encounter = entityManager.find(Encounter.class, encounterId);
		encounter.getMedOrders().add(medOrders);
		
		entityTransaction.begin();
		entityManager.merge(encounter);
		entityTransaction.commit();
		
		return encounter;
	}
}
