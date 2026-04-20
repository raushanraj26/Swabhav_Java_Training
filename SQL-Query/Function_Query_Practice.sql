-- Syntax 

-- DELIMITER //
-- CREATE FUNCTION function_name(parameter datatype)
-- RETURNS datatype
-- DETERMINISTIC
-- BEGIN
--     -- logic
--     RETURN value;
-- END //
-- DELIMITER ;

-- 1.Get Full Name Label ->Write a function get_student_label that takes a student ID and returns a string in the format: 
                          -- 'Roll: [rollnumber] - Name: [name]' from the students table.
                          
DELIMITER //
CREATE FUNCTION get_student_label(p_studentid INT)
RETURNS VARCHAR(200)
DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(200);
    SELECT CONCAT('Roll: ', rollnumber, ' - Name: ', name)
    INTO result
    FROM student
    WHERE studentid = p_studentid;
    IF result IS NULL THEN
        RETURN 'Student not found';
    END IF;
    RETURN result;
END //
DELIMITER ;

SELECT get_student_label(1);



-- 2. Calculate Percentage Grade 
-- Write a function get_grade that takes a percentage as input and returns: 
-- 'A' if percentage ≥ 90 
-- 'B' if 75–89 
-- 'C' if 50–74 
-- 'D' otherwise 

DELIMITER //
CREATE FUNCTION get_percentage_grade(p_percentage double)
RETURNS VARCHAR(200)
DETERMINISTIC
BEGIN
    DECLARE grade VARCHAR(200);
    IF p_percentage >= 90 THEN
        SET grade = 'A';
    ELSEIF p_percentage >= 75 THEN
        SET grade = 'B';
    ELSEIF p_percentage >= 50 THEN
        SET grade = 'C';
    ELSE
        SET grade = 'D';
    END IF;
    RETURN grade;
END //
DELIMITER ;

DROP FUNCTION get_percentage_grade;

SELECT name, percentage, get_percentage_grade(percentage) AS grade
FROM student;



-- 3. Get Age Category 
-- Write a function get_age_category that takes a student's age and returns 'Teen', 
-- 'Adult', or 'Senior' based on: 
-- Teen: age < 20 
-- Adult: age 20–40 
-- Senior: age > 40

DELIMITER //
CREATE FUNCTION get_age_category(p_age double)
RETURNS VARCHAR(200)
DETERMINISTIC
BEGIN
    DECLARE category VARCHAR(200);
    IF p_age <20 THEN
        SET category = 'Teen';
    ELSEIF p_age <40 THEN
        SET category = 'Adult';
    ELSE
        SET category = 'Senior';
    END IF;
    RETURN category;
END //
DELIMITER ;

SELECT name, age, get_age_category(age) AS Age_Category
FROM student;



-- 4. Check Pass or Fail 
-- Write a function is_passed that takes a percentage and returns 'Pass' if ≥ 40, 
-- otherwise 'Fail'. 


DELIMITER //
CREATE FUNCTION is_passed(p_percentage DOUBLE)
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
    IF p_percentage >= 40 THEN
        RETURN 'Pass';
    ELSE
        RETURN 'Fail';
    END IF;
END //
DELIMITER ;

SELECT name, percentage, is_passed(percentage) AS result
FROM student;

-- 5. Get Subject Count for a Student 
-- Write a function subject_count that takes a student ID and returns how many 
-- subjects the student is enrolled in (from the subjects table).

DELIMITER //
CREATE FUNCTION subject_count(p_studentid INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) 
    INTO total
    FROM subjects
    WHERE studentid = p_studentid;

    RETURN total;
END //
DELIMITER ;

select name,subject_count(studentid) as Total_Subject
from student;



-- 6. Get Course Count 
-- Write a function course_count that takes a student ID and returns the number of 
-- courses the student is enrolled in (from the student_course table)


DELIMITER //
CREATE FUNCTION course_count(p_studentid INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;
    SELECT COUNT(*)
    INTO total
    FROM student_course
    WHERE studentid = p_studentid;

    RETURN total;
END //
DELIMITER ;

SELECT name, course_count(studentid) AS total_courses
FROM student;



-- 7. Get Mobile Number 
-- Write a function get_mobile_by_student that takes a student ID and returns their 
-- mobile number from the profile table.

DELIMITER //

CREATE FUNCTION get_mobile_by_student(p_studentid INT)
RETURNS VARCHAR(15)
DETERMINISTIC
BEGIN
    DECLARE mobile VARCHAR(15);

    SELECT mobileno
    INTO mobile
    FROM profile
    WHERE studentid = p_studentid;

    RETURN mobile;
END //

DELIMITER ; 


SELECT name, get_mobile_by_student(studentid) AS mobile
FROM student;





-- 8. Average Percentage by City 
-- Write a function average_percentage_by_city that takes a city name and returns the 
-- average percentage of all students living in that city (using join with profile). 


DELIMITER //

CREATE FUNCTION average_percentage_by_city(p_city VARCHAR(50))
RETURNS DOUBLE
DETERMINISTIC
BEGIN
    DECLARE avg_per DOUBLE;

    SELECT AVG(s.percentage)
    INTO avg_per
    FROM student s
    JOIN profile p
    ON s.studentid = p.studentid
    WHERE p.city = p_city;

    RETURN avg_per;
END //

DELIMITER ;

SELECT city, average_percentage_by_city(city)
FROM profile
GROUP BY city;



-- 9. Get Highest Percentage Among All Students 
-- Write a function get_top_percentage that returns the highest percentage score from 
-- the students table. 




-- 10. Get Student Status 
-- Write a function get_student_status that takes a student ID and returns: 
-- 'Excellent' if percentage ≥ 90 
-- 'Good' if between 75–89 
-- 'Average' if between 40–74
-- 'Poor' if below 40 
-- (Use a SELECT with conditional logic)




DELIMITER //

CREATE FUNCTION get_student_status(p_studentid INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE status VARCHAR(20);

    SELECT 
        CASE
            WHEN percentage >= 90 THEN 'Excellent'
            WHEN percentage >= 75 THEN 'Good'
            WHEN percentage >= 40 THEN 'Average'
            ELSE 'Poor'
        END
    INTO status
    FROM student
    WHERE studentid = p_studentid;

    RETURN status;
END //

DELIMITER ;



SELECT name, percentage, get_student_status(studentid) AS status
FROM student;