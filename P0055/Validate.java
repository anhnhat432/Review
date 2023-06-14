/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0055;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author FPT
 */

import java.util.ArrayList;

public class Validate {

    public static boolean isCodeExist(ArrayList<Doctor> doctors, String code) {
        for (Doctor doctor : doctors) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicate(ArrayList<Doctor> doctors, Doctor doctor) {
        for (Doctor d : doctors) {
            if (d.getCode().equalsIgnoreCase(doctor.getCode()) && d.getName().equalsIgnoreCase(doctor.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositiveInteger(String input) {
        if (isInteger(input)) {
            int number = Integer.parseInt(input);
            return number >= 0;
        }
        return false;
    }
}









