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



public class Main {
    public static void main(String[] args) {
        ArrayList<Country> countryList = new ArrayList<>();
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries(countryList);
        
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.inputCountry();
                    break;
                case 2:
                    manager.printCountry();
                    break;
                case 3:
                    manager.searchByName();
                    break;
                case 4:
                    manager.printCountrySorted();
                    break;
                case 5:
                    return;
            }
        }
    }
}

