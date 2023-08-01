package com.company.lib;

import java.util.Scanner;

public class Exercise4 {
    /*
   Write a program tp count the
   letters, spaces, numbers, and other characters in an input string.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int letter = 0, space = 0, number = 0, other = 0;

        System.out.println("Enter the string: ");
        char[] tmp = scanner.nextLine().toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if (Character.isLetter(tmp[i])) {
                letter++;
            } else if (Character.isSpaceChar(tmp[i])) {
                space++;
            } else if (Character.isDigit(tmp[i])) {
                number++;
            } else {
                other++;
            }
        }
        System.out.println("There are " + letter + " letters in the string.");
        System.out.println("There are " + space + " spaces in the string.");
        System.out.println("There are " + number + " numbers in the string.");
        System.out.println("There are " + other + " other characters in the string.");
    }
}
