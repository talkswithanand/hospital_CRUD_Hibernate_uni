package com.ty.hospital_app.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.entity.Person;

public class PersonDao {
	
	private static Scanner sc = new Scanner(System.in);

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static Person createPersonObject() {
		Person person = new Person();

		System.out.println("Enter person id");
		person.setPersonId(sc.nextInt());
		System.out.println("Enter person diagnosis");
		person.setDiagnosis(sc.next());
		System.out.println("Enter no of visits");
		person.setNoOfVisits(sc.nextInt());
		System.out.println("Enter age");
		person.setAge(sc.nextInt());
		System.out.println("Enter visited doctor");
		person.setVisitedDoctor(sc.next());

		return person;
	}

	public static Person savePerson() {
		Person person = createPersonObject();

		entityTransaction.begin();

		entityManager.persist(person);

		entityTransaction.commit();

//		sc.close();
		return person;
	}

	public static Person findPerson(int personId) {
		return entityManager.find(Person.class, personId);
	}
	
}
