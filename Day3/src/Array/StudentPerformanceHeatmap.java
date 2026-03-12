package Array;
import java.util.Scanner;
public class StudentPerformanceHeatmap {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of students: ");
	        int n = sc.nextInt();

	        int[][] marks = new int[n][5];  // n students, 5 subjects

	        // Input marks
	        for (int i = 0; i < n; i++) {
	            System.out.println("\nEnter marks for Student " + (i + 1));
	            for (int j = 0; j < 5; j++) {
	                System.out.print("Subject " + (j + 1) + ": ");
	                marks[i][j] = sc.nextInt();
	            }
	        }

	        int distinctionCount = 0;

	       

	        for (int i = 0; i < n; i++) {

	            int total = 0;
	            boolean fail = false;

	            for (int j = 0; j < 5; j++) {
	                total += marks[i][j];

	                if (marks[i][j] < 35) {
	                    fail = true;
	                }
	            }

	            double average = total / 5.0;
	            String result;

	            if (fail) {
	                result = "Fail";
	            } 
	            else if (average >= 85) {
	                result = "Distinction";
	                distinctionCount++;
	            } 
	            else if (average >= 60) {
	                result = "First Class";
	            } 
	            else if (average >= 50) {
	                result = "Second Class";
	            } 
	            else {
	                result = "Fail";
	            }

	            System.out.println("Student " + i + " → Average: " + average + " → " + result);
	        }

	        // subject with highest overall average
	        double highestAvg = 0;
	        int bestSubjectIndex = 0;

	        for (int j = 0; j < 5; j++) {

	            int subjectTotal = 0;

	            for (int i = 0; i < n; i++) {
	                subjectTotal += marks[i][j];
	            }

	            double subjectAvg = subjectTotal / (double) n;

	            if (subjectAvg > highestAvg) {
	                highestAvg = subjectAvg;
	                bestSubjectIndex = j;
	            }
	        }

	      
	        System.out.println("\n--- Summary ---");
	        System.out.println("Total Distinctions: " + distinctionCount);
	        System.out.println("Subject with Highest Average: Subject " + (bestSubjectIndex + 1));
	        System.out.println("Highest Subject Average: " + highestAvg);

	        sc.close();
	    }

}
