package com.company.lib;

public class Exercise7 {
    /*
    Write a Java program to count the number
    of even and odd elements in a given array of integers.
     */
    public static void main(String[] args) {
        int[] arr = {114, 514, 1919, 810};
        int odd = 0, even = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("There are " + odd + " odd numbers.");
        System.out.println("There are " + even + " even numbers.");
    }
}
