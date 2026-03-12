package com.monocept;
import java.util.Scanner;
public class EnumClassEx {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter signal (RED, YELLOW, GREEN): ");
        String input = sc.nextLine();

        // Convert String to Enum value
        Signal s = Signal.valueOf(input.toUpperCase());

        if (s == Signal.RED) {
            System.out.println("Stop");
        } 
        else if (s == Signal.YELLOW) {
            System.out.println("Wait");
        } 
        else if (s == Signal.GREEN) {
            System.out.println("Go");
        }

        sc.close();
    }

}
enum Signal {
    RED,
    YELLOW,
    GREEN
}
