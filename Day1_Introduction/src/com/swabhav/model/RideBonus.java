package com.swabhav.model;

import java.util.Scanner;

public class RideBonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ridebonus=new Scanner(System.in);
        System.out.print("Enter an Height(in cm):");
        int height=ridebonus.nextInt();
        int totalbill=0;
        if(height>1200) {
        	System.out.print("Enter Your age in years:");
        	int age=ridebonus.nextInt();
        	if(age<12) {
        		totalbill+=5;
        		
        	}else if(age>=12 && age<=18) {
        		totalbill+=7;
        		
        	}else if(age>=45 && age<=55) {
        		totalbill+=0;
        		
        	}else {
        		totalbill+=12;
        	}
       	 
        }else {
       	 System.out.println("You can't Ride, your height is less than 1200 cm!");
        }
        
      	 System.out.println("Do You want photos? Y for yes and N for no");
      	 String ans=ridebonus.next();
      	 if(ans=="Y") {
      		totalbill+=3;

      		System.out.println("The Total bill is:" + (totalbill));
 
      	 }else {
      		System.out.println("The Total bill is:" + (totalbill));
      		 
      	 }

        
        ridebonus.close();

	}

}
