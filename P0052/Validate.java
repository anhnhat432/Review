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
public class Validate {
    public static boolean isStringEmpty(String input) {
        return input.trim().isEmpty();
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

