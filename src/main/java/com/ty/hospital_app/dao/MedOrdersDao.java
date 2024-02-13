package com.ty.hospital_app.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital_app.entity.Item;
import com.ty.hospital_app.entity.MedOrders;

public class MedOrdersDao {

	private static Scanner sc = new Scanner(System.in);

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static MedOrders createMedOrdersObject() {
		MedOrders medOrders = new MedOrders();

		System.out.println("Enter medOrder id");
		medOrders.setMedOrdersId(sc.nextInt());
		System.out.println("Enter order date");
		medOrders.setOrderDate(sc.next());
		System.out.println("Enter bill");
		medOrders.setBill(sc.nextInt());
		System.out.println("Enter payment mode");
		medOrders.setPaymentMode(sc.next());
		
		// persist item & set items
		Item item = ItemDao.saveItem();
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		medOrders.setItems(items);

		return medOrders;
	}

	public static MedOrders saveMedOrders() {
		MedOrders medOrders = createMedOrdersObject();

		entityTransaction.begin();

		ItemDao.entityTransaction.commit();// if medorders table not save, 
										  //don't commit item table also
		entityManager.persist(medOrders);

		entityTransaction.commit();

		// sc.close();
		return medOrders;
	}

	public static MedOrders findMedOrders(int medOrdersId) {

		return entityManager.find(MedOrders.class, medOrdersId) ;
	}
	
	public static MedOrders updateMedOrdersList(Item item, int medOrdersId) {
		MedOrders medOrders = entityManager.find(MedOrders.class, medOrdersId);
		medOrders.getItems().add(item);
		
		entityTransaction.begin();
		entityManager.merge(medOrders);
		entityTransaction.commit();
		
		return medOrders;
	}

}
