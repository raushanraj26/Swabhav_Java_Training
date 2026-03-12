package Array;

import java.util.Scanner;

public class ElementSum {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("ENter the size:");
		int size=scanner.nextInt();
		
		if(size>0) {
			int arr[]=new int[size];
			for(int i=0;i<arr.length;i++) {
				arr[i]=scanner.nextInt();
				
			}
			int sum=0;
			for(int i=0;i<arr.length;i++) {
				sum+=arr[i];
			}
			
			System.out.println("The Sum of element is:" + (sum));
			
		}else {
			System.out.println("Give Positive only");
		}
	}

}
