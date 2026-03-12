package Array;
import java.util.Scanner;
public class InsuranceRiskAnalyser {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        
	        System.out.print("Enter number of customers: ");
	        int n = sc.nextInt();

	        int[] ages = new int[n];
	        int[] riskScores = new int[n];

	        for (int i = 0; i < n; i++) {
	            System.out.println("\nCustomer " + (i + 1));

	            System.out.print("Enter age: ");
	            ages[i] = sc.nextInt();

	            System.out.print("Enter risk score (0-100): ");
	            riskScores[i] = sc.nextInt();
	        }

	        
	        int highRiskYouth = 0;
	        int seniorRisk = 0;
	        int veryHighRisk = 0;
	        int normalRisk = 0;

	        int totalRisk = 0;
	        int maxRisk = riskScores[0];
	        int maxIndex = 0;

	        

	        for (int i = 0; i < n; i++) {

	            String category;

	            if (ages[i] < 25 && riskScores[i] > 70) {
	                category = "High Risk Youth";
	                highRiskYouth++;
	            }
	            else if (ages[i] >= 60) {
	                category = "Senior Risk";
	                seniorRisk++;
	            }
	            else if (riskScores[i] >= 85) {
	                category = "Very High Risk";
	                veryHighRisk++;
	            }
	            else {
	                category = "Normal Risk";
	                normalRisk++;
	            }

	            System.out.println("Customer " + i + " → " + category);

	           
	            totalRisk += riskScores[i];

	           
	            if (riskScores[i] > maxRisk) {
	                maxRisk = riskScores[i];
	                maxIndex = i;
	            }
	        }

	        double averageRisk = (double) totalRisk / n;

	      
	       
	        System.out.println("High Risk Youth: " + highRiskYouth);
	        System.out.println("Senior Risk: " + seniorRisk);
	        System.out.println("Very High Risk: " + veryHighRisk);
	        System.out.println("Normal Risk: " + normalRisk);
	        System.out.println("Average Risk Score: " + averageRisk);
	        System.out.println("Index of Highest Risk Customer: " + maxIndex);

	        sc.close();
	 }

}
