/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0054;

/**
 *
 * @author FPT
 */
import java.util.Scanner;




/**
 *
 * @author THAYCACAC
 */
public class Validation {

    private final static Scanner in = new Scanner(System.in);
    private static final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";

    // Kiểm tra đầu vào số nguyên theo giới hạn
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số trong khoảng [" + min + ", " + max + "]");
                System.out.print("Nhập lại: ");
            }
        }
    }

    // Kiểm tra đầu vào chuỗi
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Không được để trống");
                System.out.print("Nhập lại: ");
            } else {
                return result;
            }
        }
    }

    // Kiểm tra đầu vào có phải là yes/no
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Vui lòng nhập y/Y hoặc n/N.");
            System.out.print("Nhập lại: ");
        }
    }

    // Kiểm tra đầu vào là số nguyên
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (Exception e) {
                System.err.println("Vui lòng nhập số");
                System.out.print("Nhập lại: ");
            }
        }
    }

    // Kiểm tra đầu vào số điện thoại
    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Vui lòng nhập số điện thoại theo các định dạng sau:\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Nhập lại: ");
        }
    }
}



