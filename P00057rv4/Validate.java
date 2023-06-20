package P00057rv4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Validate {

    public static int checkInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số trong khoảng [" + min + ", " + max + "].");
                System.out.print("Nhập lại: ");
            }
        }
    }

    public static boolean checkFileExist() {
        File file = new File("E:/user.nhat.txt");
        if (!file.exists()) {
            System.err.println("File dữ liệu không tồn tại.");
            return false;
        }
        return true;
    }

    public static String checkInputUsername() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập tên đăng nhập: ");
            String username = sc.nextLine().trim();
            if (username.isEmpty()) {
                System.err.println("Tên đăng nhập không được để trống.");
            } else {
                return username;
            }
        }
    }

    public static String checkInputPassword() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập mật khẩu: ");
            String password = sc.nextLine().trim();
            if (password.isEmpty()) {
                System.err.println("Mật khẩu không được để trống.");
            } else {
                return password;
            }
        }
    }

    public static boolean checkUsernameExist(String username) {
        File file = new File("E:/user.nhat.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    sc.close();
                    return false;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
