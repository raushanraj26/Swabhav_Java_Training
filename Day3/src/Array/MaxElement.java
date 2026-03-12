package Array;

import java.util.Scanner;

public class MaxElement {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("ENter the size:");
		int size=scanner.nextInt();
		
		if(size>0) {
			int arr[]=new int[size];
			for(int i=0;i<arr.length;i++) {
				arr[i]=scanner.nextInt();
				
			}
			int maxi=arr[0];
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>maxi) {
					maxi=arr[i];
				}
			}
			
			System.out.println("The maximum element is:" + (maxi));
			
		}else {
			System.out.println("Give Positive only");
		}
	}

}
