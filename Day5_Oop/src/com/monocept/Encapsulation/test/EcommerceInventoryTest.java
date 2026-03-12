package com.monocept.Encapsulation.test;
import com.monocept.Encapsulation.model.EcommerceInventory;
import java.util.Scanner;
public class EcommerceInventoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your Peoduct Details \n");
		System.out.println("Enter Productid:");
		int id=scanner.nextInt();
		scanner.nextLine(); 
		System.out.println("Enter Product name:");
		String name=scanner.nextLine();
	
		System.out.println("Enter Product Price:");
		double price=scanner.nextDouble();
		System.out.println("Enter Initial Stock:");
		int stock=scanner.nextInt();
		
		
		EcommerceInventory p = new EcommerceInventory(id,name,price,stock);
		while(true) {

		    System.out.println("\n----- MENU -----");
		    System.out.println("1. Display Product");
		    System.out.println("2. Increase Stock");
		    System.out.println("3. Decrease Stock");
		    System.out.println("4. Update Price");
		    System.out.println("5. Discontinue Product");
		    System.out.println("6. Exit");

		    System.out.print("Enter choice: ");
		    int choice = scanner.nextInt();

		    switch(choice) {

		        case 1:
		            p.displayProduct();
		            break;

		        case 2:
		            System.out.print("Enter quantity to increase: ");
		            int inc = scanner.nextInt();
		            p.increaseStock(inc);
		            break;

		        case 3:
		            System.out.print("Enter quantity to decrease: ");
		            int dec = scanner.nextInt();
		            p.reduceStock(dec);
		            break;

		        case 4:
		            System.out.print("Enter new price: ");
		            double newPrice = scanner.nextDouble();

		            System.out.print("Are you admin? (true/false): ");
		            boolean isAdmin = scanner.nextBoolean();

		            p.updatePrice(newPrice, isAdmin);
		            break;

		        case 5:
		            p.discontinueProduct();
		            break;

		        case 6:
		            System.out.println("Exiting...");
		            scanner.close();
		            return;

		        default:
		            System.out.println("Invalid choice! Try again.");
		    }
		}

//	        System.out.println("Initial Product:");
//	        p.displayProduct();
//
//	        System.out.println("\nIncreasing Stock:");
//	        p.increaseStock(5);
//	        p.displayProduct();
//
//	        System.out.println("\nReducing Stock:");
//	        p.reduceStock(3);
//	        p.displayProduct();
//
//	        System.out.println("\nTrying to update price as normal user:");
//	        p.updatePrice(45000, false);
//
//	        System.out.println("\nUpdating price as admin:");
//	        p.updatePrice(45000, true);
//	        p.displayProduct();
//
//	        System.out.println("\nDiscontinuing product:");
//	        p.discontinueProduct();
//
//	        System.out.println("\nTrying to increase stock after discontinue:");
//	        p.increaseStock(5);

	}

}
