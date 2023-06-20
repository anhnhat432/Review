package P0055;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> doctorList = new ArrayList<>();
        doctorList.add(new Doctor("D01", "John Doe", "General", 8));
        doctorList.add(new Doctor("D02", "Jane Smith", "Dentist", 10));
        doctorList.add(new Doctor("D03", "David Johnson", "Pediatrician", 7));

        Manager manager = new Manager(doctorList);
        manager.run();
    }
}
