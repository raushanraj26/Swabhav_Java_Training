package com.monocept.String;

import java.util.Scanner;

public class FileNameValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        
        boolean isPdf = fileName.endsWith(".pdf");

       
        int dotIndex = fileName.lastIndexOf('.');

        
        String name = fileName.substring(0, dotIndex);

      
        String extension = fileName.substring(dotIndex + 1);

       
        name = name.replace("_", " ");

       
        name = name.toUpperCase();

        
        boolean containsFinal = fileName.contains("final");

        // Output
        System.out.println("File Name: " + name);
        System.out.println("Extension: " + extension);
        System.out.println("Is PDF file: " + (isPdf ? "Yes" : "No"));
        System.out.println("Contains 'final': " + (containsFinal ? "Yes" : "No"));

        sc.close();
    }
}
