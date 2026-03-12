package Array;
import java.util.Scanner;
public class SmartLoanElligibilityChecker {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of applicants: ");
	        int n = sc.nextInt();

	        int[] creditScores = new int[n];
	        double[] monthlyIncomes = new double[n];
	        int[] existingLoans = new int[n];

	        
	        for (int i = 0; i < n; i++) {
	           

	            System.out.print("Enter credit score: ");
	            creditScores[i] = sc.nextInt();

	            System.out.print("Enter monthly income: ");
	            monthlyIncomes[i] = sc.nextDouble();

	            System.out.print("Enter number of existing loans: ");
	            existingLoans[i] = sc.nextInt();
	        }

	        int approvals = 0;
	        int rejections = 0;
	        int bestApplicantIndex = 0;
	        int bestCreditScore = creditScores[0];

	        

	        for (int i = 0; i < n; i++) {

	            String result;

	            // Rejection checker
	            if (creditScores[i] < 600 ||
	                monthlyIncomes[i] < 25000 ||
	                existingLoans[i] >= 3) {

	                result = "Rejected";
	                rejections++;
	            }
	            else {
	                // Approval checker
	                if (creditScores[i] >= 800 &&
	                    monthlyIncomes[i] > 100000) {

	                    result = "Instant Approval";
	                } else {
	                    result = "Standard Review";
	                }

	                approvals++;
	            }

	            System.out.println("Applicant " + i + " → " + result);

	            // Find best approval profile (highest credit score)
	            if (creditScores[i] > bestCreditScore) {
	                bestCreditScore = creditScores[i];
	                bestApplicantIndex = i;
	            }
	        }

	    
	        System.out.println("\n--- Summary ---");
	        System.out.println("Total Approvals: " + approvals);
	        System.out.println("Total Rejections: " + rejections);
	        System.out.println("Best Applicant Index: " + bestApplicantIndex);
	        System.out.println("Best Applicant Credit Score: " + bestCreditScore);

	        sc.close();}
}
