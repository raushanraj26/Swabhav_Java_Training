CREATE DATABASE College

USE College;

CREATE TABLE college (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    marks DOUBLE,
    branch VARCHAR(50)
);

INSERT INTO college (id, name, age, marks, branch) VALUES
(1, 'Rahul', 20, 85.5, 'CSE'),
(2, 'Anjali', 21, 90.2, 'IT'),
(3, 'Amit', 19, 78.0, 'ECE'),
(4, 'Sneha', 22, 88.8, 'CSE'),
(5, 'Vikram', 20, 67.5, 'ME'),
(6, 'Pooja', 21, 92.3, 'IT'),
(7, 'Karan', 23, 74.6, 'EE'),
(8, 'Neha', 20, 81.4, 'CSE'),
(9, 'Rohit', 22, 69.9, 'ME'),
(10, 'Priya', 21, 95.0, 'IT');
