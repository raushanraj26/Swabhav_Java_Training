package Array;

import java.util.Scanner;

public class SecondMax {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("ENter the size:");
		int size=scanner.nextInt();
		
		if(size>0) {
			int arr[]=new int[size];
			for(int i=0;i<arr.length;i++) {
				arr[i]=scanner.nextInt();
				
			}
			int first=arr[0];
			int second=arr[0];
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>first) {
					second=first;
					first=second;
				}else if(arr[i]>second && arr[i]!=first) {
					second=arr[i];
					
				}
			}
			
			System.out.println("The second maximum element is:" + (second));
			
		}else {
			System.out.println("Give Positive only");
		}
	}

}
