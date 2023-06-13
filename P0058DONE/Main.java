/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0058DONE;

/**
 *
 * @author FPT
 */
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addNewWord(dictionary);
                    break;
                case 2:
                    Manager.deleteWord(dictionary);
                    break;
                case 3:
                    Manager.translate(dictionary);
                    break;
                case 4:
                    return;
                    /*                 case 4:
                    Manager.displayDictionary(dictionary);
                    break; */
            }
        }
    }
}


