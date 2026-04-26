
package com.monocept.App.app;

import java.util.Scanner;

import com.monocept.App.model.Student;
import com.monocept.App.service.StudentService;
import com.monocept.App.util.InputValidator;

public class MainApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();

		while (true) {

			System.out.println("\n----MENU-----");
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
			int choice;

			if (!sc.hasNextInt()) {
			    System.out.println("Invalid input! Please enter a number.");
			    sc.nextLine(); // clear wrong input
			    continue;      // go back to menu
			}

			choice = sc.nextInt();
			sc.nextLine(); // clear buffer

			// validate range
			if (choice < 1 || choice > 11) {
			    System.out.println("Invalid choice! Enter between 1 and 11.");
			    continue;
			}

			switch (choice) {

			// 1. Add Student
			case 1: {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				String error = InputValidator.validateId(id);
				if (error != null) {
					System.out.println(error);
					break;
				}

				if (service.isAlreadyIdTaken(id)) {
					System.out.println("ID already exists!");
					break;
				}

				System.out.print("Enter Name: ");
				String name = sc.nextLine();

				error = InputValidator.validateName(name);
				if (error != null) {
					System.out.println(error);
					break;
				}

				System.out.print("Enter Age: ");
				int age = sc.nextInt();
				sc.nextLine();

				error = InputValidator.validateAge(age);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.showBranches();

				System.out.print("Select Branch ID: ");
				int branchId = sc.nextInt();
				sc.nextLine();

				error = InputValidator.validateBranchId(branchId);
				if (error != null) {
					System.out.println(error);
					break;
				}

				Student s = new Student(id, name, age, branchId);
				service.addStudent(s);
				break;
			}

			// 2. Register Course
			case 2: {
				System.out.print("Enter Student ID: ");
				int sid = sc.nextInt();
				sc.nextLine();

				String error = InputValidator.validateId(sid);
				if (error != null) {
					System.out.println(error);
					break;
				}

				if (!service.isAlreadyIdTaken(sid)) {
					System.out.println("Student not found!");
					break;
				}

				service.showCourses();

				System.out.print("Select Course ID: ");
				int courseId = sc.nextInt();

				error = InputValidator.validateCourseId(courseId);
				if (error != null) {
					System.out.println(error);
					break;
				}

				System.out.print("Enter Fee: ");
				double fee = sc.nextDouble();

				error = InputValidator.validateFee(fee);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.registerCourse(sid, courseId, fee);
				break;
			}

			// 3. Show all students
			case 3: {
				service.showAllStudentWithCourses();
				break;
			}

			// 4. Search student
			case 4: {
				System.out.print("Enter ID: ");
				int searchId = sc.nextInt();

				String error = InputValidator.validateId(searchId);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.ShowStudentById(searchId);
				break;
			}

			// 5. Update student
			case 5: {
				System.out.print("Enter ID: ");
				int uid = sc.nextInt();
				sc.nextLine();

				String error = InputValidator.validateId(uid);
				if (error != null) {
					System.out.println(error);
					break;
				}

				System.out.print("Enter new name: ");
				String newName = sc.nextLine();

				error = InputValidator.validateName(newName);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.showBranches();

				System.out.print("Select new Branch ID: ");
				int newBranchId = sc.nextInt();

				error = InputValidator.validateBranchId(newBranchId);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.updateStudent(uid, newName, newBranchId);
				break;
			}

			// 6. Update course fee
			case 6: {
				System.out.print("Enter Student ID: ");
				int fid = sc.nextInt();

				String error = InputValidator.validateId(fid);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.showCourses();

				System.out.print("Select Course ID: ");
				int courseId = sc.nextInt();

				error = InputValidator.validateCourseId(courseId);
				if (error != null) {
					System.out.println(error);
					break;
				}

				System.out.print("Enter new Fee: ");
				double newFee = sc.nextDouble();

				error = InputValidator.validateFee(newFee);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.updateCourseFees(fid, courseId, newFee);
				break;
			}

			// 7. Cancel registration
			case 7: {
				System.out.print("Enter Student ID: ");
				int stid = sc.nextInt();
				sc.nextLine();

				String error = InputValidator.validateId(stid);
				if (error != null) {
					System.out.println(error);
					break;
				}

				System.out.print("Enter Course to cancel: ");
				String course = sc.nextLine();

				error = InputValidator.validateCourseName(course);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.cancelRegistration(stid, course);
				break;
			}

			// 8. Delete student
			case 8: {
				System.out.print("Enter Student ID to delete: ");
				int deleteId = sc.nextInt();

				String error = InputValidator.validateId(deleteId);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.deleteStudentIncludingRegistration(deleteId);
				break;
			}

			// 9. High paying students
			case 9: {
				System.out.print("Enter minimum amount: ");
				double amount = sc.nextDouble();

				String error = InputValidator.validateFee(amount);
				if (error != null) {
					System.out.println(error);
					break;
				}

				service.HighPayingStudentReport(amount);
				break;
			}

			// 10. Course-wise count
			case 10: {
				service.coursewiseStudentCount();
				break;
			}

			// 11. Exit
			case 11: {
				System.out.println("Exiting...");
				sc.close();
				System.exit(0);
			}

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}

//package com.monocept.App.app;
//
//import java.util.Scanner;
//
//import com.monocept.App.model.Student;
//import com.monocept.App.service.StudentService;
//
//public class MainApp {
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		StudentService service = new StudentService();
//
//		while (true) {
//
//			System.out.println("\n----MENU-----");
//			System.out.println("1. Add Student");
//			System.out.println("2. Register Course");
//			System.out.println("3. Show All Students with Courses");
//			System.out.println("4. Search Student by ID");
//			System.out.println("5. Update Student");
//			System.out.println("6. Update Course Fee");
//			System.out.println("7. Cancel Registration");
//			System.out.println("8. Delete Student");
//			System.out.println("9. High Paying Students");
//			System.out.println("10. Course-wise Count");
//			System.out.println("11. Exit");
//
//			System.out.print("Enter choice: ");
//			int choice = sc.nextInt();
//			sc.nextLine(); // clear buffer
//
//			switch (choice) {
//
//			// 1. Add Student
//			case 1: {
//				System.out.print("Enter ID: ");
//				int id = sc.nextInt();
//				sc.nextLine();
//
//				if (service.isAlreadyIdTaken(id)) {
//				    System.out.println("ID already exists! Try again.");
//				    break;
//				}
//
//				System.out.print("Enter Name: ");
//				String name = sc.nextLine();
//
//				System.out.print("Enter Age: ");
//				int age = sc.nextInt();
//				sc.nextLine();
//
//				//
//				service.showBranches();
//
//				// Take branch ID input
//				System.out.print("Select Branch ID: ");
//				int branchId = sc.nextInt();
//				sc.nextLine();
//
//				// 
//				Student s = new Student(id, name, age, branchId);
//
//				service.addStudent(s);
//				break;
//			}
//
//			// 2. Register Course
//			case 2: {
//			    System.out.print("Enter Student ID: ");
//			    int sid = sc.nextInt();
//			    sc.nextLine();
//
//			    // check student exists
//			    if (!service.isAlreadyIdTaken(sid)) {
//			        System.out.println("Student not found! Please add student first.");
//			        break;
//			    }
//
//			    //Show courses
//			    service.showCourses();
//
//			    //  Take course_id
//			    System.out.print("Select Course ID: ");
//			    int courseId = sc.nextInt();
//
//			    System.out.print("Enter Fee: ");
//			    double fee = sc.nextDouble();
//
//			    //call with courseId
//			    service.registerCourse(sid, courseId, fee);
//
//			    break;
//			}
//
//			// 3. Show all students
//			case 3: {
//				service.showAllStudentWithCourses();
//				break;
//			}
//
//			// 4. Search student
//			case 4: {
//				System.out.print("Enter ID: ");
//				int searchId = sc.nextInt();
//				service.ShowStudentById(searchId);
//				break;
//			}
//
//			// 5. Update student -"id" student ka name and branch update kr do
//			case 5: {
//				System.out.print("Enter ID: ");
//				int uid = sc.nextInt();
//				sc.nextLine();
//
//				System.out.print("Enter new name: ");
//				String newName = sc.nextLine();
//
//				//Show branches
//			    service.showBranches();
//
//			    //  Take branch id
//			    System.out.print("Select new Branch ID: ");
//			    int newBranchid = sc.nextInt();
//
//				service.updateStudent(uid, newName, newBranchid);
//				break;
//			}
//
//			// 6. Update course fee
//			case 6: {
//				System.out.print("Enter Student ID: ");
//				int fid = sc.nextInt();
//				sc.nextLine();
//				
//				 //Show courses
//			    service.showCourses();
//			    //  Take course_id
//			    System.out.print("Select Course ID: ");
//			    int courseId = sc.nextInt();
//				System.out.print("Enter new Fee: ");
//				double newFee = sc.nextDouble();
//
//				service.updateCourseFees(fid, courseId, newFee);
//				break;
//			}
//
//			// 7. Cancel registration
//			case 7: {
//				System.out.print("Enter Student ID: ");
//				int stid = sc.nextInt();
//				sc.nextLine();
//
//				System.out.print("Enter Course to cancel: ");
//				String coursee = sc.nextLine();
//
//				service.cancelRegistration(stid, coursee);
//				break;
//			}
//
//			// 8. Delete student including all registration
//			case 8: {
//				System.out.print("Enter Student ID to delete: ");
//				int deleteId = sc.nextInt();
//
//				service.deleteStudentIncludingRegistration(deleteId);
//				break;
//			}
//
//			// 9. High paying students
//			case 9: {
//				System.out.print("Enter minimum amount: ");
//				double amount = sc.nextDouble();
//				service.HighPayingStudentReport(amount);
//				break;
//			}
//
//			// 10. Course-wise count
//			case 10: {
//				service.coursewiseStudentCount();
//				break;
//			}
//			// 11. Exit
//			case 11: {
//				System.out.println("Exiting...");
//				sc.close();
//				System.exit(0);
//			}
//
//			default: {
//				System.out.println("Invalid choice!");
//			}
//			}
//		}
//	}
//
//}
