create database University;
use University;
CREATE TABLE Student (
    studentid INT PRIMARY KEY,
    rollnumber INT,
    name VARCHAR(100),
    age INT,
    percentage DOUBLE
); 

INSERT INTO Student (studentid, rollnumber, name, age, percentage) VALUES 
(1, 101, 'Anjali Sharma', 18, 92.50), 
(2, 102, 'Ravi Verma', 19, 85.00), 
(3, 103, 'Priya Deshmukh', 20, 74.00), 
(4, 104, 'Amit Patel', 17, 38.00), 
(5, 105, 'Sneha Joshi', 21, 64.50), 
(6, 106, 'Arjun Mehta', 22, 49.00), 
(7, 107, 'Akshay Kumar', 18, 55.50), 
(8, 108, 'Anaya Nair', 19, 88.00), 
(9, 109, 'Bhavna Iyer', 20, 91.00), 
(10, 110, 'Chetan Salunkhe', 18, 33.00), 
(11, 111, 'Deepak Rawat', 20, 85.00), 
(12, 112, 'Asha Pawar', 19, 67.00), 
(13, 113, 'Ganesh Jadhav', 22, 75.00), 
(14, 114, 'Aditya Jain', 21, 92.50), 
(15, 115, 'Raj Thakur', 17, 40.00);


-- 1. Display all columns for all students in the table.
DELIMITER //
CREATE PROCEDURE getAllStudents()
BEGIN
    SELECT * FROM Student;
END //
DELIMITER ;

CALL getAllStudents();


-- � 2. Show the name and roll number of students who scored more than 75%.
DELIMITER //
CREATE PROCEDURE getTopStudents()
BEGIN
    SELECT name,rollnumber,percentage FROM Student where percentage >75 ;
END //
DELIMITER ;

-- DROP PROCEDURE getTopStudents;
-- DROP PROCEDURE getTopStudents;
CALL getTopStudents()


 -- 3.List students who are older than 18 and have a percentage less than 50.
 DELIMITER //
CREATE PROCEDURE getLowPerformers()
BEGIN
    SELECT* FROM Student where percentage <50 and age >18 ;
END //
DELIMITER ;

CALL getLowPerformers();
 
 
-- 4. Display all students sorted by percentage in descending order. 
DELIMITER //
CREATE PROCEDURE getSortedStudents()
BEGIN
    SELECT *
    FROM Student
    ORDER BY percentage DESC;
END //
DELIMITER ;
CAll getSortedStudents

--  5. Count the total number of students in the table. 
DELIMITER //

CREATE PROCEDURE getTotalStudents()
BEGIN
    SELECT COUNT(studentid) AS total_students
    FROM Student;
END //

DELIMITER ;

INSERT INTO Student VALUES (16,108,'Rahul',19,90);
CALL getTotalStudents();

--  6. Find the average percentage of students who are younger than 20.
DELIMITER //
CREATE PROCEDURE getAvgPercentage()
BEGIN
    SELECT AVG(percentage) AS avg_percentage
    FROM Student
    WHERE age < 20;
END //
DELIMITER ;

CALL getAvgPercentage();

-- 7. Find the student(s) who scored the highest percentage. 
-- DROP PROCEDURE IF EXISTS getTopper;
-- DELIMITER //
-- CREATE PROCEDURE getTopper()
-- BEGIN
--     SELECT *
--     FROM Student
--     WHERE percentage = (SELECT MAX(percentage) FROM Student);
-- END //
DELIMITER //
CREATE PROCEDURE getTopper()
BEGIN
    SELECT *
    FROM Student
    order by percentage desc
    LIMIT 1;
    
END //
-- CALL getTopper()// 
DELIMITER ;
CALL getTopper();

--  8. Display the number of students grouped by their age.
DELIMITER //
CREATE PROCEDURE getStudentCountByAge()
BEGIN
    SELECT age, COUNT(*) AS total_students
    FROM Student
    GROUP BY age
    order by age asc;
END //
DELIMITER ; 
-- DROP PROCEDURE IF EXISTS getStudentCountByAge;
 call getStudentCountByAge();
 
 
--  9. List all students whose name starts with the letter 'A'.
 DELIMITER //
CREATE PROCEDURE getStudentsStartingWithA()
BEGIN
    SELECT *
    FROM Student
    WHERE name LIKE 'A%';
END //
DELIMITER ;

call getStudentsStartingWithA();

--  10. Show names and percentages of students who scored above the average percentage.
 DELIMITER //
CREATE PROCEDURE  getAboveAverageStudents()
BEGIN
    SELECT name ,percentage
    FROM Student
    WHERE percentage > (select avg(percentage) from Student);
END //
DELIMITER ;

call getAboveAverageStudents();





 -- 11.Assign grades to students based on percentage: 
DELIMITER //
CREATE PROCEDURE getStudentGrades()
BEGIN
    SELECT name, percentage,
    CASE
        WHEN percentage >= 90 THEN 'A'
        WHEN percentage >= 75 THEN 'B'
        WHEN percentage >= 60 THEN 'C'
        ELSE 'D'
    END AS grade
    FROM Student;
END //
DELIMITER ;

call getStudentGrades();

-- 12. Find the second highest percentage scored by any student. 
DELIMITER //
CREATE PROCEDURE getSecondHighestPercantage()
BEGIN
select *
 from Student
 order by percentage DESC
 limit 1
 offset 1 ;
END //
DELIMITER ;
DROP PROCEDURE  getSecondHighestPercantage;
call getSecondHighestPercantage();




-- 13


-- 14.Display the rank of each student based on their percentage using a window function. 
DELIMITER //
CREATE PROCEDURE getStudentRanks()
BEGIN
    SELECT name, percentage,
   --  RANK() OVER (ORDER BY percentage DESC) AS rank_position
--      No skipping ranks
    DENSE_RANK() OVER (ORDER BY percentage DESC) AS rank_position

    FROM Student;
END //
DELIMITER ;
DROP PROCEDURE IF EXISTS getStudentRanks;
call getStudentRanks();


-- 15. Find the top 3 students with the highest percentage using a subquery and window function.  