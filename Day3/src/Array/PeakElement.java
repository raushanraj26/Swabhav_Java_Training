package Array;

import java.util.Scanner;

public class PeakElement {
	public static void main(String arg[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("ENter the size:");
		int size = scanner.nextInt();

		if (size > 0) {
			int arr[] = new int[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();

			}
			int peak = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					if (arr[i] > arr[i + 1]) {
//						peak=arr[i];
						peak++;

					}

				} else if (i == arr.length - 1) {
					if (arr[i] > arr[i - 1]) {
//						peak=arr[i]
						peak++;

					}
				} else {
					if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
//						peak=arr[i]
						peak++;
					}
				}
			}
			System.out.println(peak);

		}

		else {
			System.out.println("Give Positive only");
		}
	}
}
