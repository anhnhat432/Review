/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0053DONE;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author FPT
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = null;

        while (true) {
            hienThiMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    array = nhapMang(sc);
                    break;
                case 2:
                    if (array != null) {
                        sapXepTangDan(array);
                    } else {
                        System.out.println("Mảng chưa được khởi tạo. Vui lòng nhập phần tử trước.");
                    }
                    break;
                case 3:
                    if (array != null) {
                        sapXepGiamDan(array);
                    } else {
                        System.out.println("Mảng chưa được khởi tạo. Vui lòng nhập phần tử trước.");
                    }
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn một lựa chọn hợp lệ.");
            }

        }
    }

    private static void hienThiMenu() {
        System.out.println("========= Chương trình Bubble Sort =========");
        System.out.println("1. Nhập mảng");
        System.out.println("2. Sắp xếp tăng dần");
        System.out.println("3. Sắp xếp giảm dần");
        System.out.println("4. Thoát");
        System.out.println("Vui lòng chọn một lựa chọn:");

    }

    private static int[] nhapMang(Scanner sc) {
        System.out.print("Nhập độ dài của mảng: ");
        int length = sc.nextInt();

        if (length <= 0) {
            System.out.println("Độ dài phải lớn hơn 0.");
            return null;
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Nhập số thứ " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    private static void sapXepTangDan(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("----- Sắp xếp tăng dần -----");
        hienThiMang(array);
    }

    private static void sapXepGiamDan(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("----- Sắp xếp giảm dần -----");
        hienThiMang(array);
    }

    private static void hienThiMang(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

