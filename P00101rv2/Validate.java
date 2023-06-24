/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P00101rv2;

import java.util.ArrayList;

/**
 *
 * @author FPT
 */
public class Validate {
    // Kiểm tra trùng ID
    public static boolean validateID(int id, ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("ID already exists. Please enter a different one!");
                return false;
            }
        }
        return true;
    }
}
