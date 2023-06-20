package P0052rv3;

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
        System.out.print("Chọn chức năng: ");
        int choice = checkInputIntLimit(1, 5);
        return choice;
    }

    public void addCountry() {
        System.out.print("Nhập mã quốc gia: ");
        String countryCode = in.nextLine().trim();
        while (true) {
            if (!Validate.isStringEmpty(countryCode)) {
                boolean isExist = false;
                for (Country country : countryList) {
                    if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Mã quốc gia đã tồn tại.");
                } else {
                    break;
                }
            } else {
                System.err.println("Mã quốc gia không được để trống.");
            }
            System.out.print("Nhập lại mã quốc gia: ");
            countryCode = in.nextLine().trim();
        }

        System.out.print("Nhập tên quốc gia: ");
        String countryName = in.nextLine().trim();
        while (Validate.isStringEmpty(countryName)) {
            System.err.println("Tên quốc gia không được để trống.");
            System.out.print("Nhập lại tên quốc gia: ");
            countryName = in.nextLine().trim();
        }

        System.out.print("Nhập diện tích tổng cộng: ");
        double countryArea = checkInputDouble();

        System.out.print("Nhập địa hình: ");
        String countryTerrain = in.nextLine().trim();

        Country country = new Country(countryCode, countryName, countryArea, countryTerrain);
        countryList.add(country);
        System.out.println("Thêm thông tin quốc gia thành công.");
    }

    public void displayLatestCountry() {
        if (countryList.isEmpty()) {
            System.err.println("Danh sách trống.");
            return;
        }
        countryList.get(countryList.size() - 1).display();
    }

    public void searchByName() {
        if (countryList.isEmpty()) {
            System.err.println("Danh sách trống.");
            return;
        }
        System.out.print("Nhập tên quốc gia cần tìm kiếm: ");
        String searchName = in.nextLine().trim();
        boolean isFound = false;
        for (Country country : countryList) {
            if (country.getCountryName().toLowerCase().contains(searchName.toLowerCase())) {
                country.display();
                isFound = true;
            }
        }
        if (!isFound) {
            System.err.printf("Không tìm thấy quốc gia có tên %s.\n", searchName);
        }
    }

    public void sortByCountryName() {
        if (countryList.isEmpty()) {
            System.err.println("Danh sách trống.");
            return;
        }
        Collections.sort(countryList);
        System.out.println("Danh sách quốc gia được sắp xếp theo tên tăng dần:");
        System.out.printf("%-10s%-25s%-20s%-25s\n", "Mã QG", "Tên Quốc Gia", "Diện Tích", "Địa Hình");
        for (Country country : countryList) {
            country.display();
        }
    }

    public int checkInputIntLimit(int min, int max) {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.err.printf("Vui lòng nhập số trong khoảng từ %d đến %d.\n", min, max);
            }
        }
        return result;
    }

    public double checkInputDouble() {
        while (true) {
            String input = in.nextLine().trim();
            if (!Validate.isStringEmpty(input) && Validate.isDouble(input)) {
                return Double.parseDouble(input);
            } else {
                System.err.println("Vui lòng nhập giá trị là số thực.");
            }
        }

    }
}
