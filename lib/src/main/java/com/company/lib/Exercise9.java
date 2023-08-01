package com.company.lib;

import java.util.Scanner;

public class Exercise9 {
    /*
    Write a program to add two matrices of the same size.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        System.out.println("Enter the number of rows: ");
        row = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        col = scanner.nextInt();

        int[][] arr1= new int[row][col];
        int[][] arr2= new int[row][col];

        System.out.println("Enter the elements of the first matrix: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the elements of the second matrix: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The sum of the matrices is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr1[i][j] + arr2[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
