package com.company.lib;

import java.lang.reflect.Array;
import java.util.Random;

public class MyClass {

    public static void main(String[] args) {

        // This is an output statement.
        System.out.print("Hello world!\n");

        // The following are PRIMITIVE types:
        // int: byte(8bits), short(16bits), int(32bits), long(64bits)
        // float: float, double
        // char and boolean.
        // The following are NON-PRIMITIVE types:
        // array, string, class, etc.

        // Data declaration
        final byte byte_num = 69; // The final keywords works similarly as "const".
        short short_num = 2048;
        int int_num = 1234567;
        long long_num = 11223344556677L; // You must add an 'L' or 'l' behind long numbers.
        float float_num = 3.14159F; // You must add an 'F' or 'f' behind float numbers.
        double double_num = 9.869604401089358;
        char line_feed = '\n';
        boolean isFailure = true;
        String[][] difficulty = new String[1][4];
        difficulty[0][0] = "Easy";
        difficulty[0][1] = "Asian";
        difficulty[0][2] = "Chinese";
        difficulty[0][3] = "Emotional Damage";
        // String[] difficulty = {"Easy", "Asian", "Chinese", "Emotional Damage"};

        String lyric = "Never gonna give you up.";
        int length = lyric.length();

        // Type casting
        double num1 = int_num; // This is called "implicit type casting", num1 = 1234567.00.
        int num2 = (int)double_num; // This is called "explicit type casting", num2 = 9.

        // Arithmetic operators: + - * / %
        // Comparison operators: == != > < >= <=
        // Logical operators: && || !

        // These are conditional statements.
        if (isFailure) {
            System.out.print("You are a FAILURE!\n");
        } else {
            System.out.print("Do better next time.\n");
        }

        // This is a switch statement.
        switch (lyric) {
            case "Never gonna give you up.":
                System.out.print("You are RICKROLLED.\n");
                break;
            case "Dududu dududu dududu":
                System.out.print("DADADA.\n");
                break;
            default:
                System.out.print("Bruh\n");
        }

        // This is a while statement with break and continue.
        Random random = new Random();
        while (true) {
            if (isFailure) {
                System.out.print("Don't be stoobid next time.\n");
                break;
            } else {
                System.out.print("You are a FAILURE!\n");
                // You have 10% of chance no more being a failure.
                isFailure = random.nextInt(100) < 10;
                if (isFailure) {
                    continue;
                }
                System.out.print("You are still a FAILURE!\n");
            }
        }

        // This is a for statement.
        for (int i = 1; i <= float_num; i++) {
            System.out.print(i);
        }
        System.out.print("pi = " + float_num + "\n");

        // This is a foreach loop statement.
        for (String dif: difficulty[0]) {
            System.out.print("You are playing " + dif + ".\n");
        }
    }

}