/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0052rv3;

/**
 *
 * @author FPT
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class ManageEastAsiaCountries {

    private final static Scanner in = new Scanner(System.in);
    private ArrayList<Country> countryList;

    public ManageEastAsiaCountries(ArrayList<Country> countryList) {
        this.countryList = countryList;
    }

    public int menu() {
        System.out.println("1. Nhập thông tin về 11 quốc gia ở Đông Á");
        System.out.println("2. Hiển thị thông tin về quốc gia vừa nhập");
        System.out.println("3. Tìm kiếm thông tin quốc gia theo tên");
        System.out.println("4. Hiển thị thông tin quốc gia được sắp xếp theo tên tăng dần");
        System.out.println("5. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = checkInputIntLimit(1, 5);
        return choice;
    }

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số trong khoảng [" + min + ", " + max + "]");
                System.out.print("Nhập lại: ");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Không được để trống");
                System.out.print("Nhập lại: ");
            } else {
                return result;
            }
        }
    }

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập giá trị là số thực");
                System.out.print("Nhập lại: ");
            }
        }
    }

    public void inputCountry() {
        System.out.print("Nhập mã quấc gia: ");
        String countryCode = checkInputString();
        if (!checkCountryExist(countryCode)) {
            System.err.println("Mã quấc gia đã tồn tại.");
            return;
        }
        System.out.print("Nhập tên quấc gia: ");
        String countryName = checkInputString();
        System.out.print("Nhập diện tích tổng cộng: ");
        double countryArea = checkInputDouble();
        System.out.print("Nhập địa hình quấc gia: ");
        String countryTerrain = checkInputString();
        countryList.add(new Country(countryCode, countryName, countryArea, countryTerrain));
        System.out.println("thêm thành công.");
    }

    public void printCountry() {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "Mã", "Tên", "Diện tích", "Địa hình");
        for (Country country : countryList) {
            country.display();
        }
    }

    public void printCountrySorted() {
        Collections.sort(countryList);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "Mã", "Tên", "Diện tích", "Địa hình");
        for (Country country : countryList) {
            country.display();
        }
    }

    public void searchByName() {
        System.out.print("Nhập tên quốc gia để tìm kiếm: ");
        String countryName = checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "Mã", "Tên", "Diện tích", "Địa hình");
        for (Country country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    public boolean checkCountryExist(String countryCode) {
        for (Country country : countryList) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}

