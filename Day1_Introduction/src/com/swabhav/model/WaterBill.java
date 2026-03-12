package com.swabhav.model;

import java.util.Scanner;

public class WaterBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner waterbill=new Scanner(System.in);
        System.out.print("Enter No of units Consumed:");
        int unit=waterbill.nextInt();
        int totalbill=0;
       if(unit>100) {
    	   if(unit<=250) {
    		   totalbill+=unit*10;
    		   
    		   
    	   }else {
    		   totalbill+=unit*20;
    		   
    		   
    	   }
    	   
       }else {
    	   totalbill+=unit*5;
    	   
       }
       
       totalbill+=75;
       
       
       
       
       
                
        waterbill.close();


	}

}
