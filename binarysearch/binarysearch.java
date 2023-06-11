/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Scanner;

/**
 *
 * @author FPT
 */
public class binarysearch {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        // Khởi tạo Scanner để đọc dữ liệu đầu vào từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập số lượng phần tử của mảng
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();

        // Khởi tạo mảng với kích thước được nhập từ bàn phím
        int[] arr = new int[n];

        // Yêu cầu người dùng nhập các giá trị của mảng theo thứ tự tăng dần
        System.out.println("Nhập " + n + " giá trị của mảng theo thứ tự tăng dần:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Yêu cầu người dùng nhập giá trị muốn tìm kiếm
        System.out.print("Nhập giá trị muốn tìm kiếm: ");
        int searchValue = scanner.nextInt();

        // Gọi phương thức binarySearch() để tìm kiếm giá trị muốn tìm kiếm trong mảng
        int index = binarySearch(arr, searchValue);

        // Hiển thị kết quả tìm kiếm
        if (index == -1) {
            System.out.println("Không tìm thấy giá trị " + searchValue + " trong mảng.");
        } else {
            System.out.println("Tìm thấy giá trị " + searchValue + " tại chỉ số: " + index);
        }
    }

    /**
     * Phương thức tìm kiếm nhị phân để tìm vị trí của một giá trị trong một mảng đã sắp xếp.
     * Nếu không tìm thấy giá trị, phương thức trả về -1.
     */
    public static int binarySearch(int[] arr, int searchValue) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == searchValue) {
                // Nếu giá trị cần tìm kiếm được tìm thấy tại chỉ số mid, trả về mid
                return mid;
            } else if (arr[mid] < searchValue) {
                // Nếu giá trị cần tìm kiếm lớn hơn giá trị tại chỉ số mid, tiếp tục tìm kiếm bên phải mảng
                left = mid + 1;
            } else {
                // Nếu giá trị cần tìm kiếm nhỏ hơn giá trị tại chỉ số mid, tiếp tục tìm kiếm bên trái mảng
                right = mid - 1;
            }
        }

        // Nếu không tìm thấy giá trị cần tìm kiếm trong mảng, trả về -1
        return -1;
    }
}




