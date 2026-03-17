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

	        System.out.print("Enter number of candidates: ");
	        int n = sc.nextInt();
	        sc.nextLine();   // consume newline

	        for(int i = 0; i < n; i++) {

	            System.out.println("\nEnter details of candidate " + (i+1));

	            System.out.print("Enter name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter age: ");
	            int age = sc.nextInt();
	            sc.nextLine();  // consume newline

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
