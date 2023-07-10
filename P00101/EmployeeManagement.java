package P00101rv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class EmployeeManagement {

    public List<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        int id = employee.getId();
        while (true) {
            boolean isUnique = true;
            for (Employee emp : employees) {
                if (emp.getId() == id) {
                    System.out.println("Error: Employee with the same ID already exists.");
                    System.out.println("Please enter a different ID:");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        id = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        isUnique = false;
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine(); // Clear the input buffer
                    }
                }
            }
            if (isUnique) {
                employee.setId(id);
                employees.add(employee);
                System.out.println("Employee added successfully.");
                break;
            }
        }
    }

    public void updateEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the updated first name: ");
                String firstName = scanner.nextLine().trim().toLowerCase();
                System.out.print("Enter the updated last name: ");
                String lastName = scanner.nextLine().trim().toLowerCase();
                System.out.print("Enter the updated phone number: ");
                String phone = scanner.nextLine().trim();
                System.out.print("Enter the updated email address: ");
                String email = scanner.nextLine().trim().toLowerCase();
                System.out.print("Enter the updated address: ");
                String address = scanner.nextLine().trim();
                System.out.print("Enter the updated date of birth: ");
                String dob = scanner.nextLine().trim();
                System.out.print("Enter the updated sex: ");
                String sex = scanner.nextLine().trim().toLowerCase();
                System.out.print("Enter the updated salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter the updated agency: ");
                String agency = scanner.nextLine().trim();

                // Update the employee's information directly
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setPhone(phone);
                employee.setEmail(email);
                employee.setAddress(address);
                employee.setDob(dob);
                employee.setSex(sex);
                employee.setSalary(salary);
                employee.setAgency(agency);

                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void removeEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void searchEmployees(String name) {
        List<Employee> matchingEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            String firstName = employee.getFirstName().trim().toLowerCase();
            String lastName = employee.getLastName().trim().toLowerCase();
            if (firstName.contains(name.toLowerCase()) || lastName.contains(name.toLowerCase())) {
                matchingEmployees.add(employee);
            }
        }
        if (matchingEmployees.isEmpty()) {
            System.out.println("No employees found with the given name.");
        } else {
            System.out.println("Matching employees:");
            for (Employee employee : matchingEmployees) {
                System.out.println("ID: " + employee.getId());
                System.out.println("First Name: " + employee.getFirstName());
                System.out.println("Last Name: " + employee.getLastName());
                System.out.println("Phone: " + employee.getPhone());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("Address: " + employee.getAddress());
                System.out.println("Date of Birth: " + employee.getDob());
                System.out.println("Sex: " + employee.getSex());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("Agency: " + employee.getAgency());
                System.out.println("--------------------");
            }
        }
    }

    public void sortEmployeesBySalary() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Employees sorted by salary:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("--------------------");
        }
    }
}
// sửa so sánh contain , xóa những kí tự trắng thừa , không phân biệt hoa thường