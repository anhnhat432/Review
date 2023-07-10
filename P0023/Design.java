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

    public ArrayList<Fruit> fruits = new ArrayList<Fruit>();
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
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.print("Enter Fruit Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Price: ");
            int price = scanner.nextInt();

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.print("Enter Origin: ");
            String origin = scanner.nextLine();

            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            fruits.add(fruit);

            System.out.print("Do you want to continue (Y/N)? ");
            continueChoice = scanner.nextLine();
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

        String continueChoice;
        do {
            System.out.print("Select Item: ");
            int selectedItem = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.println("You selected: " + fruits.get(selectedItem - 1).getName());
            System.out.print("Please input quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Fruit selectedFruit = fruits.get(selectedItem - 1);
            selectedFruit = new Fruit(selectedFruit.getId(), selectedFruit.getName(),
                    selectedFruit.getPrice(), quantity, selectedFruit.getOrigin());

            shoppingCart.add(selectedFruit);

            System.out.print("Do you want to order now (Y/N)? ");
            continueChoice = scanner.nextLine();
        } while (continueChoice.equalsIgnoreCase("N"));

        System.out.print("Input your name: ");
        String customerName = scanner.nextLine();

        orders.put(customerName, shoppingCart);

        System.out.println("Order placed successfully!");

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
        int choice = scanner.nextInt();

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

