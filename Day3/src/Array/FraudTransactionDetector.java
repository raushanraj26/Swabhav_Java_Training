package Array;
import java.util.Scanner;
public class FraudTransactionDetector {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of transactions: ");
	        int n = sc.nextInt();

	        double[] transactions = new double[n];

	        
	        for (int i = 0; i < n; i++) {
	            System.out.print("Transaction " + (i + 1) + ": ");
	            transactions[i] = sc.nextDouble();
	        }

	        double total = 0;
	        boolean fraudPattern = false;

	

	        for (int i = 0; i < n; i++) {

	            total += transactions[i];

	            
	            if (transactions[i] > 50000) {
	                System.out.println("Transaction Index " + i + " → Suspicious");
	            }

	            
	            if (i > 0) {
	                if (transactions[i] > 50000 && transactions[i - 1] > 50000) {
	                    fraudPattern = true;
	                }
	            }
	        }

	        double average = total / n;

	   
	        System.out.println("Average Transaction Value: " + average);

	        if (fraudPattern) {
	            System.out.println("Fraud Pattern Detected: Potential Fraud");
	        } else {
	            System.out.println("Fraud Pattern Detected: NO");
	        }

	        if (average > 40000) {
	            System.out.println("Account Type: High Value Account");
	        } else {
	            System.out.println("Account Type: Normal Account");
	        }

	        sc.close();
	    }

}
