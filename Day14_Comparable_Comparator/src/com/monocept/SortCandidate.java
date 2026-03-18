package com.monocept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortCandidate {
	public static class Candidate{
		private String name;
	    private int age;

	    public Candidate(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String toString() {
	        return name + " " + age;
	    }
	}
	
	
	public static class CandidateComparator implements Comparator<Candidate> {

	    public int compare(Candidate c1, Candidate c2) {

	        int nameCompare = c1.getName().compareTo(c2.getName());

	        if(nameCompare != 0){
	            return nameCompare;
	        }

	        return c1.getAge() - c2.getAge();
	    }
	}
	
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        List<Candidate> list = new ArrayList<>();

	        int n = 0;

	        // ✅ Validate number of candidates
	        while (true) {
	            System.out.print("Enter number of candidates: ");
	            
	            if (sc.hasNextInt()) {
	                n = sc.nextInt();
	                sc.nextLine(); // consume newline

	                if (n > 0) {
	                    break;
	                } else {
	                    System.out.println("Number must be greater than 0!");
	                }
	            } else {
	                System.out.println("Invalid input! Enter a number.");
	                sc.nextLine(); // clear invalid input
	            }
	        }

	        for(int i = 0; i < n; i++) {

	            System.out.println("\nEnter details of candidate " + (i+1));

	            String name;
	            while (true) {
	                System.out.print("Enter name: ");
	                name = sc.nextLine();

	                if (name.matches("[a-zA-Z ]+") && !name.trim().isEmpty()) {
	                    break;
	                } else {
	                    System.out.println("Invalid name! Only letters allowed.");
	                }
	            }

	            // ✅ Validate Age
	            int age;
	            while (true) {
	                System.out.print("Enter age: ");

	                if (sc.hasNextInt()) {
	                    age = sc.nextInt();
	                    sc.nextLine(); // consume newline

	                    if (age >= 18 && age <= 60) {
	                        break;
	                    } else {
	                        System.out.println("Age must be between 18 and 60.");
	                    }
	                } else {
	                    System.out.println("Invalid input! Enter a number.");
	                    sc.nextLine(); // clear invalid input
	                }
	            }
	            Candidate c = new Candidate(name, age);

	            list.add(c);
	        }

	        // Sorting
	        Collections.sort(list, new CandidateComparator());

	        System.out.println("\nSorted Candidate List:");

	        for(Candidate c : list) {
	            System.out.println(c.getName() + " " + c.getAge());
	        }

	        sc.close();
	    }
	

}
