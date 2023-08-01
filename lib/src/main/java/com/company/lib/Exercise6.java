package com.company.lib;

public class Exercise6 {
    /*
    Write a program to multiply corresponding elements of two arrays of integers.
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {114, 514, 1919, 810};
        String result = "The result = {";

        for (int i = 0; i < arr1.length; i++) {
            if (i == arr1.length - 1) {
                result += arr1[i] * arr2[i] + "}";
            } else {
                result += arr1[i] * arr2[i] + ", ";
            }
        }

        System.out.println(result);
    }
}
