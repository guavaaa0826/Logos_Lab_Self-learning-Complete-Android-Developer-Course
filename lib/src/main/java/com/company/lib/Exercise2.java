package com.company.lib;

import java.util.Scanner;

public class Exercise2 {
    /*
    Write a program that gets from the user the radius
    and print the area and perimeter of a circle.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the radius: ");
        int radius = scanner.nextInt();

        double area = radius * radius * Math.PI;
        double perimeter = 2 * radius * Math.PI;

        System.out.println("The area is " + area);
        System.out.println("The perimeter is " + perimeter);
    }
}
