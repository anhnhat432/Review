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

public class Main {
    public static void main(String[] args) {
        ArrayList<Country> countryList = new ArrayList<>();
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries(countryList);
        int choice;
        do {
            choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.addCountry();
                    break;
                case 2:
                    manager.displayLatestCountry();
                    break;
                case 3:
                    manager.searchByName();
                    break;
                case 4:
                    manager.sortByCountryName();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
            }
        } while (choice != 5);
    }
}


