package P00057;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Manager {

    public static int menu() {
        System.out.println("1. Tạo tài khoản mới.");
        System.out.println("2. Đăng nhập hệ thống.");
        System.out.println("3. Thoát.");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = Validate.checkInputIntLimit(1, 3);
        return choice;
    }

    public static void createNewAccount() {
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUsername();
        String password = Validate.checkInputPassword();
        if (Validate.checkUsernameExist(username)) {
            System.err.println("Tên đăng nhập đã tồn tại.");
            return;
        }
        addAccountData(username, password);
    }

    public static void loginSystem() {
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUsername();
        String password = Validate.checkInputPassword();
        if (!Validate.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
                System.err.println("Sai mật khẩu.");
                return;
            }
            System.err.println("Đăng nhập thành công.");
        }
    }

    public static void addAccountData(String username, String password) {
        File file = new File("E:/user.nhat.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
            System.err.println("Tạo thành công.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String passwordByUsername(String username) {
        File file = new File("E:/user.nhat.txt");
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
