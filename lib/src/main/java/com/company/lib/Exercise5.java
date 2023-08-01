package com.company.lib;

import java.util.Scanner;

public class Exercise5 {
    /*
   Write a program to reverse a string.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string: ");
        char[] str = scanner.nextLine().toCharArray();
        System.out.print("The reversed string: ");

        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i]);
        }
        System.out.println("");
    }
}
