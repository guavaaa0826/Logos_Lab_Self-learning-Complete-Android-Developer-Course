package com.company.lib;

import java.util.Scanner;

public class Exercise8 {
    /*
    Write a program to make such a pattern like a pyramid
    with a number which will repeat the number in the same row.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the row number: ");
        int row = scanner.nextInt();
        for (int i = 1; i <= row; i++) {
            for (int j = row; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j != 1) {
                    System.out.print(" ");
                }
                System.out.print(i);
            }
            for (int j = row; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
