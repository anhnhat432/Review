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

public class Main {
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi đọc lựa chọn

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
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
    }

    private static void addDoctor() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();

        // Kiểm tra mã bác sĩ đã tồn tại hay chưa
        if (Validate.isCodeExist(doctorList, code)) {
            System.out.println("Code already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter availability: ");
        String availabilityStr = scanner.nextLine();

        // Kiểm tra tính hợp lệ của số lượng
        if (!Validate.isPositiveInteger(availabilityStr)) {
            System.out.println("Invalid availability. Please enter a non-negative integer.");
            return;
        }

        int availability = Integer.parseInt(availabilityStr);

        Doctor doctor = new Doctor(code, name, specialization, availability);

        // Kiểm tra bác sĩ đã bị trùng lặp hay chưa
        if (Validate.isDuplicate(doctorList, doctor)) {
            System.out.println("Duplicate doctor. Please enter unique information.");
            return;
        }

        doctorList.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    private static void updateDoctor() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();

        // Tìm bác sĩ theo mã
        Doctor doctor = findDoctorByCode(code);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new specialization: ");
        String newSpecialization = scanner.nextLine();
        System.out.print("Enter new availability: ");
        String newAvailabilityStr = scanner.nextLine();

        // Kiểm tra tính hợp lệ của số lượng
        if (!Validate.isPositiveInteger(newAvailabilityStr)) {
            System.out.println("Invalid availability. Please enter a non-negative integer.");
            return;
        }

        int newAvailability = Integer.parseInt(newAvailabilityStr);

        // Kiểm tra xem thông tin đã thay đổi hay chưa
        if (!Validate.isDuplicate(doctorList, new Doctor(code, newName, newSpecialization, newAvailability))) {
            System.out.println("Duplicate doctor. Please enter unique information.");
            return;
        }

        // Cập nhật thông tin bác sĩ
        doctor.setName(newName);
        doctor.setSpecialization(newSpecialization);
        doctor.setAvailability(newAvailability);

        System.out.println("Doctor updated successfully.");
    }

    private static void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();

        // Tìm bác sĩ theo mã
        Doctor doctor = findDoctorByCode(code);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        doctorList.remove(doctor);
        System.out.println("Doctor deleted successfully.");
    }

    private static void searchDoctor() {
        System.out.print("Enter code: ");
        String code = scanner.nextLine();

        // Tìm bác sĩ theo mã
        Doctor doctor = findDoctorByCode(code);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.println(doctor.toString());
    }

    private static Doctor findDoctorByCode(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }
}

