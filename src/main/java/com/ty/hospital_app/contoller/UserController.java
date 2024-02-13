package com.ty.hospital_app.contoller;

import com.ty.hospital_app.helper.HelperClass;

public class UserController {

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to Hospital Management System!!!");
			boolean flag = true;
			while (flag) {
				int choice = HelperClass.initials();
				switch (choice) {
				case 1:HelperClass.branchOperation();
					break;
				case 2:HelperClass.encounterOperation();
				break;
				case 3:HelperClass.medOrdersOperation();
					break;
				case 4: flag = false;
				break;
				default: System.out.println("You have selected wrong option.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			main(null);
//			System.out.println("Wrong Input!");
		}
	}

}
