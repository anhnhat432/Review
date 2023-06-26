package P00101rv2;

class Validate {
    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
    }

    public static boolean isValidDate(String date) {
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }
    
    public static boolean isValidSex(String sex) {
        return sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female");
    }
}
