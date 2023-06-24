/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P00101rv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagement employeeManagement = new EmployeeManagement();

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "Doe", "123-456-7890", "john.doe@example.com", "123 Main St, Anytown, USA", "01/01/1980", "Male", 50000.0, "ABC Company"));
        employeeList.add(new Employee(2, "Jane", "Smith", "123-456-7890", "jane.smith@example.com", "456 Market St, Anytown, USA", "02/02/1990", "Female", 60000.0, "XYZ Corporation"));
        employeeList.add(new Employee(3, "David", "Johnson", "123-456-7890", "david.johnson@example.com", "789 Broadway St, Anytown, USA", "03/03/1985", "Male", 70000.0, "DEF Inc."));

        while (true) {
            System.out.println("\nMain menu:");
            System.out.println("1. Add employees");
            System.out.println("2. Update employees");
            System.out.println("3. Remove employees");
            System.out.println("4. Search employees");
            System.out.println("5. Sort employees by salary");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the input buffer
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter date of birth: ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter sex: ");
                    String sex = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter agency: ");
                    String agency = scanner.nextLine();

                    Employee employee = new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
                    employeeManagement.addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    employeeManagement.updateEmployee(updateId);
                    break;

                case 3:
                    System.out.print("Enter employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    employeeManagement.removeEmployee(removeId);
                    break;

                case 4:
                    System.out.print("Enter employee name to search: ");
                    String searchName = scanner.nextLine();
                    employeeManagement.searchEmployees(employeeList, searchName);

                    break;

                case 5:
                    employeeManagement.sortEmployeesBySalary();
                    break;

                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
