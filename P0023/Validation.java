/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

/**
 *
 * @author FPT
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    private static final Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number in the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input must not be empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be an integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be a double.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputYN() {
    while (true) {
        String result = checkInputString();
        if (result.equalsIgnoreCase("Y") || result.equalsIgnoreCase("N")) {
            return result.toUpperCase();
        }
        System.err.println("Please input Y or N.");
        System.out.print("Enter again: ");
    }
}


public static boolean checkIdExist(ArrayList<Fruit> lf, int id) {
    for (Fruit fruit : lf) {
        if (fruit.getId() == id) {
            return false;
        }
    }
    return true;
}
}

