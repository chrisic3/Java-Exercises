/*
    Read the numbers from the console entered by the user and print the minimum and maximum number the user has entered.
    Before the user enters the number, print the message "Enter number:"
    If the user enters an invalid number, break out of the loop and print the minimum and maximum number.

    Hint:
    Use an endless while loop.
 */

package com.minandmaxinputchallenge;

import java.util.Scanner;

public class MinAndMaxInputChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean hasNextInt;
        int number = 0;

        while (true) {
            System.out.println("Enter number:");
            hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                number = scanner.nextInt();
                if (number < min) {
                    min = number;
                }

                if (number > max) {
                    max = number;
                }
            } else {
                break;
            }

            scanner.nextLine();
        }

        System.out.println(min);
        System.out.println(max);

        scanner.close();
    }
}
