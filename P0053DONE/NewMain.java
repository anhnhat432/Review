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
            displayMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    array = inputElements(sc);
                    break;
                case 2:
                    if (array != null) {
                        sortAscending(array);
                    } else {
                        System.out.println("Array is not initialized. Please input elements firts");
                    }
                    break;
                case 3:
                    if (array != null) {
                        sortDescending(array);
                    } else {
                        System.out.println("Array is not initialized. Please input elements firts");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    sc.close();
                default:
                    System.out.println("invalid choice . please select a valid option.");
            }

        }
    }

    private static void displayMenu() {
        System.out.println("========= Bubble Sort program =========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
        System.out.println("Please choice one option:");

    }

    private static int[] inputElements(Scanner sc) {
        System.out.print("Enter the length of the array: ");
        int length = sc.nextInt();

        if (length <= 0) {
            System.out.println("length must be greater than 0.");
            return null;
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Enter Number " + (i + 1) + "; ");
            array[i] = sc.nextInt();
        }
        return array;
    }

private static void sortAscending(int[] array) {
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

        System.out.println("----- Ascending -----");
        displayArray(array);
    }

    private static void sortDescending(int[] array) {
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

        System.out.println("----- Descending -----");
        displayArray(array);
    }

    private static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
