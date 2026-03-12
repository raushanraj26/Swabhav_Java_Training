package com.monocept.stream;


import java.io.*;
import java.util.Scanner;

public class FileService {

    String filePath = "data/students.txt";
    Scanner sc = new Scanner(System.in);

    // CREATE
    public void createRecord() throws Exception {

        FileOutputStream fos = new FileOutputStream(filePath, true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        bw.write(id + "," + name + "," + course);
        bw.newLine();

        bw.close();
        fos.close();

        System.out.println("Record added successfully");
    }

    // READ
    public void readRecords() throws Exception {

        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;

        System.out.println("\n--- Records ---");

        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        fis.close();
    }

    // UPDATE
    public void updateRecord() throws Exception {

        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        BufferedWriter bw = new BufferedWriter(new FileWriter("data/temp.txt"));

        String line;

        while((line = br.readLine()) != null) {

            if(line.startsWith(id + ",")) {

                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new course: ");
                String course = sc.nextLine();

                bw.write(id + "," + name + "," + course);
            }
            else {
                bw.write(line);
            }

            bw.newLine();
        }

        br.close();
        bw.close();

        File oldFile = new File(filePath);
        File newFile = new File("data/temp.txt");

        oldFile.delete();
        newFile.renameTo(oldFile);

        System.out.println("Record updated");
    }

    // DELETE
    public void deleteRecord() throws Exception {

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        BufferedWriter bw = new BufferedWriter(new FileWriter("data/temp.txt"));

        String line;

        while((line = br.readLine()) != null) {

            if(!line.startsWith(id + ",")) {
                bw.write(line);
                bw.newLine();
            }
        }

        br.close();
        bw.close();

        File oldFile = new File(filePath);
        File newFile = new File("data/temp.txt");

        oldFile.delete();
        newFile.renameTo(oldFile);

        System.out.println("Record deleted");
    }
}