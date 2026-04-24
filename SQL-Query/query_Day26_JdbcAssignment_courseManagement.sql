create database CollegeManagement;
use collegemanagement;
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    branch VARCHAR(50)
);

CREATE TABLE registration (
    reg_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_name VARCHAR(50),
    fees_paid DOUBLE,
    FOREIGN KEY (student_id) REFERENCES student(id)
);

show tables;

select * from student;
select * from registration;