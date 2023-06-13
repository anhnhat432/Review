package P0058DONE;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Manager {

    public static int menu() {
        System.out.println("1. Thêm từ mới.");
        System.out.println("2. Xóa từ.");
        System.out.println("3. Tra từ.");
        System.out.println("4. Thoát.");
        System.out.print("Nhập lựa chọn: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    public static void addNewWord(HashMap<String, String> dictionary) {
        System.out.print("Nhập từ tiếng Anh: ");
        String english = Validation.checkInputString();
        if (dictionary.containsKey(english)) {
            System.out.println("Từ đã tồn tại.");
            return;
        }
        System.out.print("Nhập nghĩa tiếng Việt: ");
        String vietnamese = Validation.checkInputString();
        dictionary.put(english, vietnamese);
        System.err.println("Thêm từ thành công.");
    }

    public static void deleteWord(HashMap<String, String> dictionary) {
        System.out.print("Nhập từ tiếng Anh: ");
        String english = Validation.checkInputString();
        if (!dictionary.containsKey(english)) {
            System.err.println("Không tìm thấy từ.");
            return;
        }
        dictionary.remove(english);
        System.err.println("Xóa từ thành công.");
    } 
  /*    public static void displayDictionary(HashMap<String, String> dictionary) {
        System.out.println("Bảng từ điển:");
        Set<Map.Entry<String, String>> entries = dictionary.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
      } */

    public static void translate(HashMap<String, String> dictionary) {
        System.out.print("Nhập từ tiếng Anh: ");
        String english = Validation.checkInputString();
        String vietnamese = dictionary.getOrDefault(english, "Không tìm thấy trong từ điển");
        System.out.println("Nghĩa tiếng Việt: " + vietnamese);
    }

    public static boolean checkKeywordExist(HashMap<String, String> dictionary, String english) {
        return dictionary.containsKey(english);
    }
}

