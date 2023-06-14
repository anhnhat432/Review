/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0058DONE;

/**
 *
 * @author FPT
 */

import java.util.Scanner;

public class Validation {

    private final static Scanner scanner = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số trong khoảng [" + min + ", " + max + "]");
                System.out.print("Nhập lại: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Không được để trống");
                System.out.print("Nhập lại: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN() {
        System.out.print("Bạn có muốn thay thế (Y/N)? ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Vui lòng nhập Y hoặc N.");
            System.out.print("Nhập lại: ");
        }
    }
}


