package com.policy.main;

import com.policy.dao.*;
import com.policy.entity.*;

import java.util.Scanner;

public class PolicyMain {
	public static void main(String[] args) {
		LICOperations licOperations = new LICOperations();
		Policy policy = new Policy();
		int ch = 0;
		while (ch == 0) {
			System.out.println("Select below options");
			System.out.println("1 -> Create Policy");
			System.out.println("2 -> Read Policy");
			System.out.println("3 -> Update Policy");
			System.out.println("4 -> Delete Policy");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Enter PolicyName");
				policy.setPolicyName(sc.next());
				System.out.println("Enter PolicyHolderName");
				policy.setPolicyHolderName(sc.next());
				System.out.println("Enter Policy Start Date (YYYY-MM-DD)");
				policy.setPolicyStartDate(sc.next());
				System.out.println("Enter PremiumType");
				policy.setPremiumType(sc.next());
				System.out.println("Enter Premium Amount");
				policy.setPremiumAmt(sc.nextFloat());
				int result = licOperations.createPolicy(policy);
				if (result == 0) {
					System.out.println("Failed to insert..!!");
				} else {
					System.out.println("Inserted successfully...!!");
				}
				break;
			}
			case 2: {
				System.out.println("Enter policy number to see details");
				policy.setPolicyNumber(sc.nextInt());
				licOperations.displayPolicy(policy);
				break;
			}
			case 3: {
				System.out.println("Enter Policy Number to update");
				policy.setPolicyNumber(sc.nextInt());
				System.out.println("Enter PolicyName");
				policy.setPolicyName(sc.next());
				System.out.println("Enter PolicyHolderName");
				policy.setPolicyHolderName(sc.next());
				System.out.println("Enter Policy Start Date (YYYY-MM-DD)");
				policy.setPolicyStartDate(sc.next());
				System.out.println("Enter PremiumType");
				policy.setPremiumType(sc.next());
				System.out.println("Enter Premium Amount");
				policy.setPremiumAmt(sc.nextFloat());
				int result = licOperations.updatePolicy(policy);
				if (result == 0) {
					System.out.println("Failed to update..!!");
				} else {
					System.out.println("Updated successfully...!!");
				}
				break;
			}
			case 4: {
				System.out.println("Enter Policy Number to delete");
				policy.setPolicyNumber(sc.nextInt());
				int result = licOperations.deletePolicy(policy);
				if (result == 0) {
					System.out.println("Failed to delete..!!");
				} else {
					System.out.println("Deleted successfully...!!");
				}
				break;
			}
			}
			System.out.println("Press 0 to continue");
			ch = sc.nextInt();
		}
	}
}
