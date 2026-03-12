package com.monocept.String;


import java.util.Scanner;
public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the input string: ");
		String s=sc.nextLine();
		boolean found = false;

        for(int i = 0; i < s.length(); i++) {

            int cnt = 0;

            for(int j = 0; j < s.length(); j++) {

                if(s.charAt(i) == s.charAt(j)) {
                    cnt++;
                }
            }

            if(cnt == 1) {
                System.out.println("First non repeating character: " + s.charAt(i));
                found = true;
                break;
            }
        }

        if(found == false) {
            System.out.println("No non-repeating character found");
        }
		


	}

}
