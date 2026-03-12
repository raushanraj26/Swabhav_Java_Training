package Array;
import java.util.Scanner;
public class ElectricityUsagePateernDetector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        int days = 30;
	        int[] usage = new int[days];

	        System.out.println("Enter electricity usage for 30 days:");

	        
	        for (int i = 0; i < days; i++) {
	            System.out.print("Day " + (i + 1) + ": ");
	            usage[i] = sc.nextInt();
	        }

	        int highConsumptionCount = 0;
	        int totalUsage = 0;
	        boolean overloadWarning = false;

	      

	        for (int i = 0; i < days; i++) {

	            String category = "";

	            if (usage[i] > 500) {
	                category = "High Consumption";
	                highConsumptionCount++;
	            } 
	            else if (usage[i] < 100) {
	                category = "Low Usage Alert";
	            } 
	            else {
	                category = "Normal Usage";
	            }

	            System.out.println("Day " + (i + 1) + " → " + category);

	            totalUsage += usage[i];

	            // Check for 3 consecutive days > 500
	            if (i >= 2) {
	                if (usage[i] > 500 &&
	                    usage[i - 1] > 500 &&
	                    usage[i - 2] > 500) {
	                    overloadWarning = true;
	                }
	            }
	        }

	        double average = (double) totalUsage / days;

	        
	        System.out.println("Monthly Average Usage: " + average);
	        System.out.println("High Consumption Days: " + highConsumptionCount);

	        if (overloadWarning) {
	            System.out.println("Overload Warning: YES (3 consecutive high usage days found)");
	        } else {
	            System.out.println("Overload Warning: NO");
	        }

	        if (average > 400) {
	            System.out.println("Heavy Month: YES");
	        } else {
	            System.out.println("Heavy Month: NO");
	        }

	        sc.close();

	}

}
