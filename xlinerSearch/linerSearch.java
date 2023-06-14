/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xlinerSearch;

import java.util.Scanner;

/**
 *
 * @author FPT
 */
public class linerSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.print("Nhập giá trị cần tìm kiếm: ");
        int searchNum = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập phần tử thứ %d: ", i + 1);
            arr[i] = input.nextInt();
        }

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == searchNum) {
                System.out.printf("Đã tìm thấy giá trị %d tại vị trí %d trong mảng.\n", searchNum, i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy " + searchNum + " trong mảng.");
        }
    }
}
