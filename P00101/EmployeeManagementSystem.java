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
                    String phone;
                    do {
                        System.out.print("Enter phone number: ");
                        phone = scanner.nextLine();
                        if (!Validate.isValidPhone(phone)) {
                            System.out.println("Invalid phone number. Please enter a valid phone number.");
                        }
                    } while (!Validate.isValidPhone(phone));

                    String email;
                    do {
                        System.out.print("Enter email address: ");
                        email = scanner.nextLine();
                        if (!Validate.isValidEmail(email)) {
                            System.out.println("Invalid email address. Please enter a valid email address.");
                        }
                    } while (!Validate.isValidEmail(email));

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    String dob;
                    do {
                        System.out.print("Enter date of birth (dd/mm/yyyy): ");
                        dob = scanner.nextLine();
                        if (!Validate.isValidDate(dob)) {
                            System.out.println("Invalid date of birth. Please enter a valid date in the format dd/mm/yyyy.");
                        }
                    } while (!Validate.isValidDate(dob));

                    String sex;
                    do {
                        System.out.print("Enter sex (Male/Female): ");
                        sex = scanner.nextLine();
                        if (!Validate.isValidSex(sex)) {
                            System.out.println("Invalid sex. Please enter a valid date in the format (Male/Female");
                        }
                    } while (!Validate.isValidSex(sex));

                    double salary;
                    do {
                        System.out.print("Enter salary: ");
                        try {
                            salary = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character
                            if (salary <= 0) {
                                System.out.println("Invalid salary. Please enter a positive value.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine(); // Clear the input buffer
                            salary = -1;
                        }
                    } while (salary <= 0);

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
                    String searchName = scanner.nextLine().trim();
                    employeeManagement.searchEmployees(searchName);
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
