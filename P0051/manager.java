/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0051;

import java.util.Scanner;

/**
 *
 * @author FPT
 */

import java.util.Scanner;


public class manager {
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            performAction(choice);
        } while (choice != 3);
    }

    private void displayMenu() {
        System.out.println("1. Máy tính thông thường");
        System.out.println("2. Máy tính chỉ số BMI");
        System.out.println("3. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private int getUserChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số từ 1 đến 3.");
                System.out.print("Nhập lại lựa chọn: ");
            }
        }
        return choice;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 1:
                performNormalCalculator();
                break;
            case 2:
                performBMICalculation();
                break;
            case 3:
                System.out.println("Kết thúc chương trình.");
                break;
        }
    }

    private void performNormalCalculator() {
        double memory;
        System.out.println("----- Normal Calculator -----");
        
       System.out.println("Enter number: ");
       memory = getDoubleInput();
        while (true) {
            System.out.print("Enter operator: "); 
            String operator = getOperatorInput();
            if (operator.equals("+")) {
                System.out.println("Enter number: ");
                memory += getDoubleInput();
                System.out.println("Memory: " + memory);
            } else if (operator.equals("-")) {
                System.out.println("Enter number: ");
                memory -= getDoubleInput();
                System.out.println("Memory: " + memory);
            } else if (operator.equals("*")) {
                System.out.println("Enter number: ");
                memory *= getDoubleInput();
                System.out.println("Memory: " + memory);
            } else if (operator.equals("/")) {
                System.out.println("Enter number: ");
                memory /= getDoubleInput();
                System.out.println("Memory: " + memory);
            } else if (operator.equals("^")) {
                System.out.println("Enter number: ");
                memory = Math.pow(memory, getDoubleInput());
                System.out.println("Memory: " + memory);
            } else if (operator.equals("=")) {
                System.out.println("Enter number: ");
                System.out.println("Result: " + memory);
                break;
            }
        }
    }

    private void performBMICalculation() {
        System.out.print("Nhập cân nặng (kg): ");
        double weight = getDoubleInput();
        System.out.print("Nhập chiều cao (cm): ");
        double height = getDoubleInput();

        double bmi = calculateBMI(weight, height);
        String status = getBMIStatus(bmi);

        System.out.printf("Chỉ số BMI: %.2f\n", bmi);
        System.out.println("Tình trạng BMI: " + status);
    }

    private double getDoubleInput() {
        double number;
        while (true) {
            try {
                number = Double.parseDouble(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số.");
                System.out.print("Nhập lại: ");
            }
        }
        
    }

    private String getOperatorInput() {
        String operator;
        while (true) {
            operator = scanner.nextLine().trim();
            if (operator.isEmpty()) {
                System.err.println("Vui lòng không để trống.");
            } else if (operator.equals("+") || operator.equals("-") || operator.equals("*") ||
                    operator.equals("/") || operator.equals("^") || operator.equals("=")) {
                break;
            } else {
                System.err.println("Vui lòng nhập phép toán hợp lệ (+, -, *, /, ^, =).");
            }
            System.out.print("Nhập lại phép toán: ");
        }
        return operator;
    }

    private double calculateBMI(double weight, double height) {
        height /= 100; // Chuyển chiều cao từ cm sang m
        return weight / (height * height);
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 19) {
            return "Thiếu cân.";
        } else if (bmi < 25) {
            return "Bình thường.";
        } else if (bmi < 30) {
            return "Thừa cân.";
        } else if (bmi < 40) {
            return "Béo phì.";
        } else {
            return "Rất béo phì.";
        }
    }
}







