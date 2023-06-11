/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0054;

/**
 *
 * @author FPT
 */

import java.util.ArrayList;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        contactList.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        contactList.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));

        // Vòng lặp cho đến khi người dùng muốn thoát
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createContact(contactList);
                    break;
                case 2:
                    Manager.printAllContact(contactList);
                    break;
                case 3:
                    Manager.deleteContact(contactList);
                    break;
                case 4:
                    return;
            }
        }
    }
}




