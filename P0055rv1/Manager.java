package P0055rv1;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public ArrayList<Doctor> doctors;
    public Scanner scanner;

    public Manager(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
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
        scanner.nextLine();
        return choice;
    }

    private void addDoctor() {
        String code;
        String name;
        String specialization;
        int availability;
        boolean duplicateCode;

        do {
        
            System.out.print("Enter code: ");
            code = scanner.nextLine();
            boolean isValidate = Validate.validateCode(code);
            System.out.println(" isValidate = "+isValidate);
            duplicateCode = Validate.checkDuplicateCode(code, doctors);
            if (!Validate.validateCode(code) || duplicateCode) {
                if (!Validate.validateCode(code)) {
                    System.out.println("Invalid code format. Please try again.");
                }
                if (duplicateCode) {
                    System.out.println("Code already exists. Please enter a different code.");
                }
            }
        } while (!Validate.validateCode(code) || duplicateCode);

        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (!Validate.validateName(name)) {
                System.out.println("Invalid name format. Please try again.");
            }
        } while (!Validate.validateName(name));
        do {
            System.out.print("Enter new specialization: ");
            specialization = scanner.nextLine();
            if (!Validate.validateSpecialization(specialization)) {
                System.out.println("Invalid specialization format. Please try again.");
            }
        } while (!Validate.validateSpecialization(specialization));
        do {
            System.out.print("Enter new availability: ");
            availability = scanner.nextInt();
            scanner.nextLine();
            if (!Validate.validateAvailability(availability)) {
                System.out.println("Invalid availability value. Please try again.");
            }
        } while (!Validate.validateAvailability(availability));

        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    private void updateDoctor() {
        String code;
        do {
            System.out.print("Enter code: ");
            code = scanner.nextLine();
            if (!Validate.validateCode(code)) {
                System.out.println("Invalid name format. Please try again.");
            }
        } while (!Validate.validateCode(code));

        Doctor doctor = findDoctorByCode(code);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        String name;
        do {
            System.out.print("Enter new name: ");
            name = scanner.nextLine();
            if (!Validate.validateName(name)) {
                System.out.println("Invalid name format. Please try again.");
            }
        } while (!Validate.validateName(name));

        String specialization;
        do {
            System.out.print("Enter new specialization: ");
            specialization = scanner.nextLine();
            if (!Validate.validateSpecialization(specialization)) {
                System.out.println("Invalid specialization format. Please try again.");
            }
        } while (!Validate.validateSpecialization(specialization));

        int availability;
        do {
            System.out.print("Enter new availability: ");
            availability = scanner.nextInt();
            scanner.nextLine();
            if (!Validate.validateAvailability(availability)) {
                System.out.println("Invalid availability value. Please try again.");
            }
        } while (!Validate.validateAvailability(availability));

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
        System.out.print("Enter name : ");
        String name = scanner.nextLine();

        ArrayList<Doctor> foundDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (name.isEmpty() || doctor.getName().contains(name)) {
                foundDoctors.add(doctor);
            }
        }
// tìm hiểu rõ dòng code , chuẩn hóa sâu tìm kiếm , không phân biệt hoa thường
        if (foundDoctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("Doctors found:");
            for (Doctor doctor : foundDoctors) {
                System.out.println(doctor);
            }
        }
    }

    private Doctor findDoctorByCode(String code) {
        for (Doctor doctor : doctors) {
            if (doctor.getCode().equals(code)) {
                return doctor;
            }
        }
        return null;
    }
}
