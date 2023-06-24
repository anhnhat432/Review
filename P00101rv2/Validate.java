package P00101rv2;

class Validate {
    public static boolean isValidPhone(String phone) {
        // Implement logic to validate phone number
        // Return true if valid, false otherwise
        // Example validation logic:
        // Phone number must be in the format xxx-xxx-xxxx, where x is a digit
        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    public static boolean isValidEmail(String email) {
        // Implement logic to validate email address
        // Return true if valid, false otherwise
        // Example validation logic:
        // Email address must have a valid format (e.g., example@example.com)
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
    }

    public static boolean isValidDate(String date) {
        // Implement logic to validate date
        // Return true if valid, false otherwise
        // Example validation logic:
        // Date must be in the format dd/mm/yyyy, where dd, mm, and yyyy are digits
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean isValidSalary(double salary) {
        // Implement logic to validate salary
        // Return true if valid, false otherwise
        // Example validation logic:
        // Salary must be a positive value
        return salary > 0;
    }
    
    public static boolean isValidSex(String sex) {
        // Implement logic to validate sex
        // Return true if valid, false otherwise
        // Example validation logic:
        // Sex must be either "Male" or "Female"
        return sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female");
    }
}
