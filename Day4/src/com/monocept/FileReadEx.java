package com.monocept;
import java.io.File;
import java.util.Scanner;
public class FileReadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            File file = new File("data.txt");
	            Scanner sc = new Scanner(file);

	            while (sc.hasNextLine()) {
	                System.out.println(sc.nextLine());
	            }

	            sc.close();
	        } 
	        catch (Exception e) {
	            System.out.println("File not found!");
	        }		

	}

}
