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
import java.io.FileWriter;
import java.io.IOException;

public class Manager {

    // Hiển thị menu
    public static int menu() {
        System.out.println("1. Tạo tài khoản mới.");
        System.out.println("2. Đăng nhập hệ thống.");
        System.out.println("3. Thoát.");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = Validate.checkInputIntLimit(1, 3);
        return choice;
    }

    // Tạo tài khoản mới
    public static void createNewAccount() {
        // Kiểm tra xem file dữ liệu đã tồn tại chưa
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUsername();
        String password = Validate.checkInputPassword();
        // Kiểm tra xem tên đăng nhập đã tồn tại chưa
        if (!Validate.checkUsernameExist(username)) {
            System.err.println("Tên đăng nhập đã tồn tại.");
            return;
        }
        addAccountData(username, password);
    }

    // Đăng nhập hệ thống
    public static void loginSystem() {
        // Kiểm tra xem file dữ liệu đã tồn tại chưa
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUsername();
        String password = Validate.checkInputPassword();
        // Kiểm tra xem tên đăng nhập đã tồn tại chưa
        if (!Validate.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
                System.err.println("Sai mật khẩu.");
            }
            System.err.println("Đăng nhập thành công.");
        }
    }

    // Ghi thông tin tài khoản mới vào dữ liệu
    public static void addAccountData(String username, String password) {
        File file = new File("D:/user.dat");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
            System.err.println("Tạo thành công.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Lấy mật khẩu dựa trên tên đăng nhập
    public static String passwordByUsername(String username) {
        File file = new File("D:/user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

