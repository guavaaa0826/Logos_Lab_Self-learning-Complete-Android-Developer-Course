package com.company.lib;

import java.util.Scanner;

public class Exercise10 {
    /*
    Write a program to calculate the average value of array elements.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 0, count = 0;

        System.out.println("Enter the amount of the numbers: ");
        count = scanner.nextInt();
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < count; i++) {
            value += scanner.nextInt();
        }

        double average = (double) value / count;
        System.out.println("The average value of the numbers is: " + average);
    }
}
