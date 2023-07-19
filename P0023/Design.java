/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author FPT
 */


public class Design {

    public ArrayList<Fruit> fruits;
    public Hashtable<String, ArrayList<Fruit>> orders;

    public Design() {
        fruits = new ArrayList<>();
        orders = new Hashtable<>();
    }

    public void createFruit() {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;

        do {
            System.out.print("Enter Fruit Id: ");
            int id = Validation.checkInputInt();

            System.out.print("Enter Fruit Name: ");
            String name = Validation.checkInputString();

            System.out.print("Enter Price: ");
            int price = Validation.checkInputInt();

            System.out.print("Enter Quantity: ");
            int quantity = Validation.checkInputInt();

            System.out.print("Enter Origin: ");
            String origin = Validation.checkInputString();

            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            fruits.add(fruit);

            System.out.print("Do you want to continue (Y/N)? ");
            continueChoice = Validation.checkInputYN();
        } while (continueChoice.equalsIgnoreCase("Y"));

        displayFruits();
        displayMainScreen();
    }

    public void displayFruits() {
        System.out.println("List of Fruits:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            System.out.println(String.format("%8d %15s %18s %12d$", (i + 1), fruit.getName(),
                    fruit.getOrigin(), fruit.getPrice()));
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        for (String customer : orders.keySet()) {
            System.out.println("Customer: " + customer);

            ArrayList<Fruit> shoppingCart = orders.get(customer);
            double totalAmount = 0;

            System.out.println("Product | Quantity | Price | Amount");
            for (Fruit fruit : shoppingCart) {
                double amount = fruit.getPrice() * fruit.getQuantity();
                totalAmount += amount;
                System.out.println(
                        String.format("%8s %10d %8d$ %8.2f$", fruit.getName(), fruit.getQuantity(),
                                fruit.getPrice(), amount));
            }

            System.out.println("Total: " + totalAmount + "$\n");
        }
    }

public void shopping() {
    displayFruits();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Fruit> shoppingCart = new ArrayList<>();

    String continueChoice = "";
    do {
        System.out.print("Chọn một mục: ");
        int selectedItem = Validation.checkInputInt();

        if (selectedItem < 1 || selectedItem > fruits.size()) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            break;
        }

        System.out.println("Bạn đã chọn: " + fruits.get(selectedItem - 1).getName());

        int quantity;
        while (true) {
            System.out.print("Vui lòng nhập số lượng: ");
            quantity = Validation.checkInputInt();

            Fruit selectedFruit = fruits.get(selectedItem - 1);
            if (quantity > selectedFruit.getQuantity()) {
                System.out.println("Số lượng không đủ. Vui lòng thử lại.");
            } else {
                break;
            }
        }

        Fruit selectedFruit = fruits.get(selectedItem - 1);
        selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity); 

        shoppingCart.add(new Fruit(
                selectedFruit.getId(),
                selectedFruit.getName(),
                selectedFruit.getPrice(),
                quantity,
                selectedFruit.getOrigin()
        ));

        System.out.print("Bạn có muốn đặt hàng ngay bây giờ (Y/N)? ");
        continueChoice = Validation.checkInputYN();
    } while (continueChoice.equalsIgnoreCase("N"));

    System.out.print("Nhập tên của bạn: ");
    String customerName = Validation.checkInputString();

    orders.put(customerName, shoppingCart);

    System.out.println("Đặt hàng thành công!");

    displayMainScreen();
}


    public void displayMainScreen() {
        System.out.println("\nFRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose an option: ");
        int choice = Validation.checkInputIntLimit(1, 4);

        switch (choice) {
            case 1:
                createFruit();
                break;
            case 2:
                viewOrders();
                break;
            case 3:
                shopping();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.\n");
                displayMainScreen();
        }
    }
}



