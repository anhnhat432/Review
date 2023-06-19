/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P00057;

/**
 *
 * @author FPT
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);
    private final static String VALID_USERNAME = "^\\S{5}\\S*$";
    private final static String VALID_PASSWORD = "^\\S{6}\\S*$";

    // Kiểm tra giới hạn số nguyên đầu vào từ người dùng
    public static int checkInputIntLimit(int min, int max) {
        // Lặp cho đến khi người dùng nhập đúng
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

    // Kiểm tra chuỗi đầu vào từ người dùng
    public static String checkInputString() {
        // Lặp cho đến khi người dùng nhập đúng
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

    // Kiểm tra đầu vào từ người dùng là yes/no
    public static boolean checkInputYN() {
        // Lặp cho đến khi người dùng nhập đúng
        while (true) {
            String result = checkInputString();
            // Trả về true nếu người dùng nhập y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            // Trả về false nếu người dùng nhập n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Vui lòng nhập y/Y hoặc n/N.");
            System.out.print("Nhập lại: ");
        }
    }

    // Kiểm tra xem file dữ liệu có tồn tại hay không
    public static boolean checkFileExist() {
        File file = new File("D:/user.dat");
        if (!file.exists()) {
            try {
                System.err.println("File không tồn tại!!!");
                file.createNewFile();
                System.err.println("Đã tạo file.");
                return false;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    // Cho phép người dùng nhập tên đăng nhập
    public static String checkInputUsername() {
        System.out.print("Nhập tên đăng nhập: ");
        // Lặp cho đến khi người dùng nhập đúng
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_USERNAME)) {
                return result;
            }
            System.err.println("Bạn phải nhập ít nhất 5 ký tự và không có khoảng trắng!");
            System.out.print("Nhập lại: ");
        }
    }

    // Cho phép người dùng nhập mật khẩu
    public static String checkInputPassword() {
        System.out.print("Nhập mật khẩu: ");
        // Lặp cho đến khi người dùng nhập đúng
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PASSWORD)) {
                return result;
            }
            System.err.println("Bạn phải nhập ít nhất 6 ký tự và không có khoảng trắng!");
            System.out.print("Nhập lại: ");
        }
    }

    // Kiểm tra xem tên đăng nhập đã tồn tại hay chưa
    public static boolean checkUsernameExist(String username) {
        File file = new File("D:/user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return false;
                }
            }
            bufferedReader.close();
            fileReader.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
