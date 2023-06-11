/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0004DONE;

/**
 *
 * @author FPT
 */

    /**
     * @param args the command line arguments
     */
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập số lượng phần tử của mảng từ người dùng
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        // Tạo mảng và nhập giá trị từng phần tử từ người dùng
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Hiển thị mảng chưa sắp xếp
        System.out.println("Unsorted array: " + Arrays.toString(array));
        
        // Sắp xếp mảng bằng thuật toán QuickSort
        quickSort(array, 0, n - 1);
        
        // Hiển thị mảng đã sắp xếp
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
    
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                
                // Hoán đổi giá trị hai phần tử
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        // Hoán đổi giá trị pivot vào vị trí đúng
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
}


