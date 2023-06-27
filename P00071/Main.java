/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P00071;

/**
 *
 * @author FPT
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static int checkIntLimit(int min, int max) {
        int input;
        while (true) {
            System.out.print("Enter a number between " + min + " and " + max + ": ");
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.err.println("Invalid input. Please try again.");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please try again.");
            }
        }
    }

    private static String checkInputDate() {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            format.setLenient(false);
            try {
                Date date = format.parse(input);
                return format.format(date);
            } catch (ParseException ex) {
                System.err.println("Invalid date format. Please try again.");
            }
        }
    }

    private static String checkInputString() {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty. Please try again.");
            } else {
                return input;
            }
        }
    }

    private static double checkInputTime() {
        double input;
        while (true) {
            System.out.print("Enter a time (8.0 - 17.5): ");
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input >= 8.0 && input <= 17.5) {
                    return input;
                } else {
                    System.err.println("Invalid input. Please try again.");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please try again.");
            }
        }
    }

    private static void addTask(ArrayList<Task> taskList, int id) {
        System.out.print("Enter Requirement Name: ");
        String requirementName = checkInputString();
        System.out.print("Enter Task Type (1: Code, 2: Test, 3: Manager, 4: Learn): ");
        String taskTypeId = checkInputTaskTypeId();
        System.out.print("Enter a date (dd-MM-yyyy): ");
        String date = checkInputDate();
        System.out.print("Enter From: ");
        double planFrom = checkInputTime();
        System.out.print("Enter To: ");
        double planTo = checkInputTime();
        System.out.print("Enter Assignee: ");
        String assign = checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = checkInputString();
        taskList.add(new Task(id, taskTypeId, requirementName, date, Double.toString(planFrom), Double.toString(planTo), assign, reviewer));
        System.out.println("Task added successfully.");
    }

    private static void deleteTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }
        int index = findTaskIndex(taskList);
        if (index != -1) {
            taskList.remove(index);
            for (int i = index; i < taskList.size(); i++) {
                taskList.get(i).setId(taskList.get(i).getId() - 1);
            }
            System.out.println("Task deleted successfully.");
        }
    }

    private static int findTaskIndex(ArrayList<Task> taskList) {
        System.out.print("Enter task ID: ");
        int id = checkInputInt();
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Task not found.");
        return -1;
    }

    private static void displayTasks(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }
        System.out.println("Task List:");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : taskList) {
            double timeDifference = Double.parseDouble(task.getPlanTo()) - Double.parseDouble(task.getPlanFrom());
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskTypeId(),
                    task.getDate(),
                    timeDifference,
                    task.getAssign(),
                    task.getReviewer()
            );
        }
    }

    private static String checkInputTaskTypeId() {
        int input = checkIntLimit(1, 4);
        String result = null;
        switch (input) {
            case 1:
                result = "code";
                break;
            case 2:
                result = "test";
                break;
            case 3:
                result = "manager";
                break;
            case 4:
                result = "learn";
                break;
        }
        return result;
    }

    private static int checkInputInt() {
        int input;
        while (true) {
            System.out.print("Enter a number: ");
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please try again.");
            }
        }
    }

    private static void display() {
        ArrayList<Task> taskList = new ArrayList<>();
        int choice;
        int id = 1;
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addTask(taskList, id);
                    id++;
                    break;
                case 2:
                    deleteTask(taskList);
                    id--;
                    break;
                case 3:
                    displayTasks(taskList);
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        display();
    }
}

