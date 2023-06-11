/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0052DONE;

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
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
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
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
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
                System.err.println("Please input a double value");
                System.out.print("Enter again: ");
            }
        }
    }

    public void inputCountry() {
        System.out.print("Enter country code: ");
        String countryCode = checkInputString();
        if (!checkCountryExist(countryCode)) {
            System.err.println("Country code already exists.");
            return;
        }
        System.out.print("Enter country name: ");
        String countryName = checkInputString();
        System.out.print("Enter total area: ");
        double countryArea = checkInputDouble();
        System.out.print("Enter country terrain: ");
        String countryTerrain = checkInputString();
        countryList.add(new Country(countryCode, countryName, countryArea, countryTerrain));
        System.out.println("Add successful.");
    }

    public void printCountry() {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "Code", "Name", "Area", "Terrain");
        for (Country country : countryList) {
            country.display();
        }
    }

    public void printCountrySorted() {
        Collections.sort(countryList);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "Code", "Name", "Area", "Terrain");
        for (Country country : countryList) {
            country.display();
        }
    }

    public void searchByName() {
        System.out.print("Enter the country name to search for: ");
        String countryName = checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "Code", "Name", "Area", "Terrain");
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

