package com.company.lib;

import java.util.Scanner;

class Exercise1 {
    /*
    Write a program that gets from the user 2 numbers
    and display their division and remainder.
     */
    /*
    You should choose the option "Run with Coverage"
    while running the main() using the green triangle on the left side.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();

        double division = (double) num1 / num2;
        int remainder = num1 % num2;

        System.out.println("The division of the numbers = " + division);
        System.out.println("The remainder of the numbers = " + remainder);
    }
}