package com.monocept.App.app;

import java.util.Scanner;

import com.monocept.App.model.Student;
import com.monocept.App.service.StudentService;

public class MainApp {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Register Course");
            System.out.println("3. Show All Students with Courses");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Update Student");
            System.out.println("6. Update Course Fee");
            System.out.println("7. Cancel Registration");
            System.out.println("8. Delete Student");
            System.out.println("9. High Paying Students");
            System.out.println("10. Course-wise Count");
            System.out.println("11. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                // 1. Add Student
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();

                    Student s = new Student(id, name, age, branch);
                    service.addStudent(s);
                    break;

                // 2. Register Course
                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Fee: ");
                    double fee = sc.nextDouble();

                    service.registerCourse(sid, course, fee);
                    break;

                // 3. Show all students
                case 3:
                    service.showAllStudentWithCourses();
                    break;

                // 4. Search student
                case 4:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    service.ShowStudentById(searchId);
                    break;

                // 5. Update student
                case 5:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new branch: ");
                    String newBranch = sc.nextLine();

                    service.updateStudent(uid, newName, newBranch);
                    break;

                // 6. Update course fee
                case 6:
                    System.out.print("Enter Student ID: ");
                    int fid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String fcourse = sc.nextLine();

                    System.out.print("Enter new Fee: ");
                    double newFee = sc.nextDouble();

                    service.updateCourseFees(fid, fcourse, newFee);
                    break;

                // 7. Cancel registration (⚠️ not implemented yet in service)
                case 7:
                    System.out.println("Cancel Registration not implemented yet");
                    break;

                // 8. Delete student (⚠️ not implemented yet in service)
                case 8:
                    System.out.println("Delete Student not implemented yet");
                    break;

                // 9. High paying students
                case 9:
                    System.out.print("Enter minimum amount: ");
                    double amount = sc.nextDouble();
                    service.HighPayingStudentReport(amount);
                    break;

                // 10. Course-wise count
                case 10:
                    service.coursewiseStudentCount();
                    break;

                // 11. Exit
                case 11:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

}
