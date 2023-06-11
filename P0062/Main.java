/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0062;

/**
 *
 * @author FPT
 */
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    private static double checkInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please re-enter.");
            }
        }
    }

    private static Triangle inputTriangle() {
        while (true) {
            System.out.print("Please enter side A of the triangle: ");
            double sideA = checkInputDouble();
            System.out.print("Please enter side B of the triangle: ");
            double sideB = checkInputDouble();
            System.out.print("Please enter side C of the triangle: ");
            double sideC = checkInputDouble();
            if (isValidTriangle(sideA, sideB, sideC)) {
                return new Triangle(sideA, sideB, sideC);
            } else {
                System.out.println("Invalid triangle sides. Please re-enter.");
            }
        }
    }

    private static boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB;
    }

    private static Rectangle inputRectangle() {
        System.out.print("Please enter the width of the rectangle: ");
        double width = checkInputDouble();
        System.out.print("Please enter the length of the rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    private static Circle inputCircle() {
        System.out.print("Please enter the radius of the circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    private static void display(Triangle triangle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

    public static void main(String[] args) {
        Rectangle rectangle = inputRectangle();
        Circle circle = inputCircle();
        Triangle triangle = inputTriangle();

        display(triangle, rectangle, circle);
    }
}

