/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P00101rv2;

/**
 *
 * @author FPT
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    public List<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void updateEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the updated first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter the updated last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter the updated phone number: ");
                String phone = scanner.nextLine();
                System.out.print("Enter the updated email address: ");
                String email = scanner.nextLine();
                System.out.print("Enter the updated address: ");
                String address = scanner.nextLine();
                System.out.print("Enter the updated date of birth: ");
                String dob = scanner.nextLine();
                System.out.print("Enter the updated sex: ");
                String sex = scanner.nextLine();
                System.out.print("Enter the updated salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter the updated agency: ");
                String agency = scanner.nextLine();

                employee = new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
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

public void searchEmployees(List<Employee> employeeList, String name) {
    List<Employee> matchingEmployees = new ArrayList<>();
    for (Employee employee : employeeList) {
        if (employee.getFirstName().equalsIgnoreCase(name) || employee.getLastName().equalsIgnoreCase(name)) {
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
// tạo thêm các validate