create database student_course;
use student_course;

CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    age INT NOT NULL,
    city VARCHAR(50) NOT NULL
);


CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL,
    duration VARCHAR(50) NOT NULL,
    fees DOUBLE NOT NULL,
    trainer_name VARCHAR(100) NOT NULL
);


CREATE TABLE registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    registration_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,

    FOREIGN KEY (student_id)
        REFERENCES students(student_id),

    FOREIGN KEY (course_id)
        REFERENCES courses(course_id)
);

-- Insert default admin 
INSERT INTO admin (username, password)
VALUES ('admin', 'admin123');


INSERT INTO students
(student_name, email, phone, age, city)
VALUES
('Rahul Kumar', 'rahul@gmail.com', '9876543210', 22, 'Delhi');
select * from students;


INSERT INTO courses
(course_name, duration, fees, trainer_name)
VALUES
('Java Full Stack', '6 Months', 45000, 'Amit Sharma');


INSERT INTO registrations
(student_id, course_id, registration_date, status)
VALUES
(1, 1, '2026-05-06', 'Active');