package Array;

import java.util.Scanner;

public class CountFrequency {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("ENter the size:");
		int size=scanner.nextInt();
		
		if(size>0) {
			int arr[]=new int[size];
			for(int i=0;i<arr.length;i++) {
				arr[i]=scanner.nextInt();
				
			}
			boolean visited[]=new boolean[arr.length];
			for (int i = 0; i < arr.length; i++) {
				if (visited[i] == true) {
					continue;
				}
				int cnt = 0;
				for (int j = i; j < arr.length; j++) {

					if (arr[i] == arr[j]) {
						cnt++;
						visited[j] = true;
					}
				}
				System.out.println((arr[i]) + " -> " + (cnt));

			}
			
		}else {
			System.out.println("Give Positive only");
		}
		
	}

}
