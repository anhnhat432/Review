/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author FPT1174
 */
public class TaskManager {

    private static final Scanner in = new Scanner(System.in);
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";
    static ArrayList<Task> tasks = new ArrayList<>();

    private static int validateInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number within the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    private static String validateInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    private static int validateInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number");
                System.out.print("Enter again: ");
            }
        }
    }

    private static String validateInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            } catch (ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String validateInputPlan() {
        while (true) {
            String result = validateInputString();
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
                return result;
            } else {
                System.err.println("Re-input.");
            }
        }
    }

    private static String validateType() {
        while (true) {
            int n = validateInputIntLimit(1, 4);
            String result = null;
            switch (n) {
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
    }

    private static void addTask() {
        System.out.print("Requirement Name: ");
        String name = validateInputString();
        System.out.print("Task Type: ");
        String type = validateType();
        System.out.print("Date: ");
        String date = validateInputDate();
        System.out.print("From: ");
        String f = validateInputPlan();
        System.out.print("To: ");
        String t = validateInputPlan();
        while (Double.parseDouble(f) >= Double.parseDouble(t)) {
            System.out.println("The 'From' time cannot be greater than the 'To' time. Please try again.");
            System.out.print("From: ");
            f = validateInputPlan();
            System.out.print("To: ");
            t = validateInputPlan();
        }
        System.out.print("Assignee: ");
        String assignee = validateInputString();
        System.out.print("Reviewer: ");
        String reviewer = validateInputString();
        tasks.add(new Task(tasks.size() + 1, type, name, date, f, t, assignee, reviewer));
        System.err.println("Add successful.");
    }

    private static void deleteTask(int id) {
        if (tasks.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int foundIndex = findTaskExist(id);
        if (foundIndex != -1) {
            tasks.remove(foundIndex);
            for (int i = foundIndex; i < tasks.size(); i++) {
                tasks.get(i).setTaskId(tasks.get(i).getTaskId() - 1);
            }
            System.err.println("Delete success.");
        }
    }

    private static int findTaskExist(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }

    public static void printTasks() {
        if (tasks.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("----------------------------TASK-----------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    tasks.get(i).getTaskId(),
                    tasks.get(i).getRequirement(),
                    tasks.get(i).getTaskTypeId(),
                    tasks.get(i).getDate(),
                    Double.parseDouble(tasks.get(i).getPlanEndTime()) - Double.parseDouble(tasks.get(i).getPlanStartTime()),
                    tasks.get(i).getAssignee(),
                    tasks.get(i).getReviewer()
            );

        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = validateInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    System.out.print("Enter Id: ");
                    int id = validateInputInt();
                    deleteTask(id);
                    break;
                case 3:
                    printTasks();
                    break;
                case 4:
                    return;
            }
        }
    }
}

