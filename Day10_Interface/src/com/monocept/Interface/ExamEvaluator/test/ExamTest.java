package com.monocept.Interface.ExamEvaluator.test;

import java.util.Scanner;
import com.monocept.Interface.ExamEvaluator.model.*;

public class ExamTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Exam exam = null;

        while (true) {

            System.out.println("\n--- Exam Menu ---");
            System.out.println("1. Theory Exam");
            System.out.println("2. Practical Exam");
            System.out.println("3. Online Quiz");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    exam = new TheoryExam();
                    break;

                case 2:
                    exam = new PracticalExam();
                    break;

                case 3:
                    exam = new OnlineQuiz();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            exam.evaluateMarks(marks);

            System.out.println("Result: " + exam.calculateGrade());
        }
    }
}
