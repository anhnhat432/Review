package P0055;

public class Validate {
    public static boolean validateCode(String code) {
        return code.matches("^D\\d{2}$");
    }

    public static boolean validateName(String name) {
        return name.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean validateSpecialization(String specialization) {
        return specialization.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean validateAvailability(int availability) {
        return availability >= 0;
    }
}
