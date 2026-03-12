package Array;

import java.util.Scanner;

public class BasicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = scanner.nextInt();
		if (size > 0) {
			int num[] = new int[size];
			for (int i = 0; i < size; i++) {
				num[i] = scanner.nextInt();
			}

			for (int i = 0; i < size; i++) {
				System.out.println(num[i]);
			}

		} else {
			System.out.println("Give positive number");
		}

	}

}
