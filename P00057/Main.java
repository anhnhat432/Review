package P00057;

public class Main {

    public static void main(String[] args) {
        // Vòng lặp cho đến khi người dùng muốn thoát
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createNewAccount();
                    break;
                case 2:
                    Manager.loginSystem();
                    break;
                case 3:
                    return;
            }
        }
    }
}
