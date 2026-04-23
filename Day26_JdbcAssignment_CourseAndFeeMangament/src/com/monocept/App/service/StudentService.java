package com.monocept.App.service;

import com.monocept.App.dao.RegistrationDao;
import com.monocept.App.dao.StudentDao;
import com.monocept.App.model.Student;

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
	
	
	//4.Search student by id
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
	public void updateStudent(int id,String name,String branch) {
		//check student available or not
		if (! studentDao.StudentAlreadyExist(id)) {
			System.out.println("Sorry this student not available");
			return;
		}
		
		if(studentDao.updateStudent(id, name, branch)) {
			System.out.println("updated Successfully!");
		}else {
			System.out.println("Failed");
			
		}
		
		
		
	}
	
	//6.Update course fees
			public void updateCourseFees(int studentid,String branch,Double fees) {
				if (! studentDao.StudentAlreadyExist(studentid)) {
					System.out.println("Sorry this student not available");
					return;
				}
				
				if(regDao.updateFee(studentid, branch, fees)) {
					System.out.println("Updated successfully");
					
				}else {
					System.out.println("Branch not found");
				}
			}	
	
//	7.cancel registration
			
			
			
			
			
//	8.delete Student	
			
			
			
//9.show student High paying.more than threshold
		public void HighPayingStudentReport(Double amount)	{
			regDao.highPayingStudents(amount);
		}
		
		
//10.Course wise student count
		public void coursewiseStudentCount() {
			regDao.courseWiseCount();
		}

}
