/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0055;

/**
 *
 * @author FPT
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private ArrayList<Doctor> doctors;
    private Scanner scanner;

    public Manager() {
        doctors = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void displayMenu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private void addDoctor() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter availability: ");
        int availability = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    private void updateDoctor() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        Doctor doctor = findDoctorByCode(code);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter new availability: ");
        int availability = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.out.println("Doctor updated successfully.");
    }

    private void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        Doctor doctor = findDoctorByCode(code);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        doctors.remove(doctor);
        System.out.println("Doctor deleted successfully.");
    }

    private void searchDoctor() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        ArrayList<Doctor> foundDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getName().contains(name)) {
                foundDoctors.add(doctor);
            }
        }

        if (foundDoctors.isEmpty()) {
            System.out.println("No doctors found with the given name.");
        } else {
            System.out.println("Doctors found with the given name:");
            for (Doctor doctor : foundDoctors) {
                System.out.println(doctor);
            }
        }
    }

    private Doctor findDoctorByCode(String code) {
        for (Doctor doctor : doctors) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }
}



 
