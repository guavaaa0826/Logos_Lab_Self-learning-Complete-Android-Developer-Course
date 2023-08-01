package com.company.lib;

import java.util.Scanner;

public class Exercise3 {
    /*
   Write a program to convert a decimal number to binary number.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the decimal number: ");
        int dec = scanner.nextInt();

        String bin = Integer.toBinaryString(dec);

        System.out.println("The binary number is " + bin);
    }
}
