package com.monocept.App.service;

import java.sql.Connection;

import com.monocept.App.dao.RegistrationDao;
import com.monocept.App.dao.StudentDao;
import com.monocept.App.model.Student;
import com.monocept.App.util.DButil;

public class StudentService {
	private StudentDao studentDao = new StudentDao();
	private RegistrationDao regDao = new RegistrationDao();

//	    1.add student
	public void addStudent(Student s) {
		// validation
		if (s.getName() == null || s.getName().isEmpty()) {
			System.out.println("Name cannot be empty");
			return;
		}

		if (s.getAge() <= 0) {
			System.out.println("Invalid age");
			return;
		}
//before add check already exist or not
		if (studentDao.StudentAlreadyExist(s.getId())) {
			System.out.println("this student already Exist!");
			return;
		}
		// call DAO
		boolean result = studentDao.addStudent(s);

		if (result) {
			System.out.println("Student added");
		} else {
			System.out.println("Failed");
		}

	}

	// 2.course enroll
	public void registerCourse(int studentId, String course, double fee) {
//	    	check->1.student exist or not, 2.duplicate corse

		// if student not available in student db
		if (!studentDao.StudentAlreadyExist(studentId)) {
			System.out.println("Student doesn't exist! first enroll into Stundent db then course enroll");
			return;
		}
		// check already enrolled hai ya nhi
		if (regDao.checkAlreadyEnrollInSameCourse(studentId, course)) {
			System.out.println("Student already enrolled in same course");
			return;

		}

		// then course me enroll kr do
		boolean success = regDao.registerCourse(studentId, course, fee);

		if (success) {

			System.out.println("Course registered");
		} else {
			System.out.println("failed");
		}
	}

//3.Show all student with course
	public void showAllStudentWithCourses() {
		regDao.viewAllStudentsWithCourses();
	}

	// 4.Search student by id
	public void ShowStudentById(int id) {
		regDao.getStudentFullDetailsbyId(id);

//		 Student s = studentDao.getStudentById(id);
//		    if (s == null) {
//		        System.out.println("Student not found");
//		    } else {
//		        System.out.println(
//		            s.getId() + " | " +
//		            s.getName() + " | " +
//		            s.getAge() + " | " +
//		            s.getBranch()
//		        );
//		    }
	}

//	5.Update name and branch of student
	public void updateStudent(int id, String name, String branch) {
		// check student available or not
		if (!studentDao.StudentAlreadyExist(id)) {
			System.out.println("Sorry this student not available");
			return;
		}

		if (studentDao.updateStudent(id, name, branch)) {
			System.out.println("updated Successfully!");
		} else {
			System.out.println("Failed");

		}

	}

	// 6.Update course fees
	public void updateCourseFees(int studentid, String branch, Double fees) {
		if (!studentDao.StudentAlreadyExist(studentid)) {
			System.out.println("Sorry this student not available");
			return;
		}

		if (regDao.updateFee(studentid, branch, fees)) {
			System.out.println("Updated successfully");

		} else {
			System.out.println("Branch not found");
		}
	}

//	7.cancel registration-->first delete registration by specific  course ,and then  if student dont have any course then delete student by id
	
	public void cancelRegistration(int studentId, String course) {

	    try {
	    	Connection con = DButil.getConnection();
	        boolean deleted = regDao.deleteRegistrationByCourse(con, studentId, course);

	        if (deleted) {
	            System.out.println("Course removed successfully");
	        } else {
	            System.out.println("No such course found for this student");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	

//	8.delete Student	including registration-->fisrt delete all registration and then student
	public void deleteStudentIncludingRegistration(int id) {

		try {
			//check student existence
			if (!studentDao.StudentAlreadyExist(id)) {
		        System.out.println("Student does not exist");
		        return;
		    }
			Connection connection = DButil.getConnection();

			connection.setAutoCommit(false);

			// first delete registration
			boolean regDeleted = regDao.deleteRegistrationRecordsById(connection, id);
			// then student
			boolean studentDeleted = studentDao.deleteStudent(connection, id);

			if (regDeleted && studentDeleted) {
				connection.commit();
				System.out.println("Student and registrations deleted successfully");
			} else {
				connection.rollback();
				System.out.println("Delete failed, rolled back");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// also rollback if exception
		}
	}

//9.show student High paying.more than threshold
	public void HighPayingStudentReport(Double amount) {
		regDao.highPayingStudents(amount);
	}

//10.Course wise student count
	public void coursewiseStudentCount() {
		regDao.courseWiseCount();
	}
	
	//11.check "id" is present or not-->if koi student already exist means not available this id otherwise avaialable
	public boolean isAlreadyIdTaken(int id) {
		return studentDao.StudentAlreadyExist(id);
	}

}
