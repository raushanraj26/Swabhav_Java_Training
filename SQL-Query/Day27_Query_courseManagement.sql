create database coursemanagament;
use coursemanagament;
CREATE TABLE branch (
    branch_id INT PRIMARY KEY AUTO_INCREMENT,
    branch_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE course (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(50) UNIQUE NOT NULL
);


CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT,
    branch_id INT,
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id)
);


CREATE TABLE registration (
    reg_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    fees_paid DOUBLE,
    FOREIGN KEY (student_id) REFERENCES student(id) ,
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);