/*
    Write a method called inputThenPrintSumAndAverage that does not have any parameters.

    The method should not return anything (void) and it needs to keep reading int numbers from the keyboard.
    When the user enters something that is not an int then it needs to print a message in the format "SUM = XX AVG
        = YY".
    XX represents the  sum of all entered numbers of type int.
    YY represents the calculated average of all numbers of type double.

    EXAMPLES OF INPUT/OUTPUT:
    EXAMPLE 1:
    INPUT:
    1
    2
    3
    4
    5
    a

    OUTPUT
    SUM = 15 AVG = 3.000000

    EXAMPLE 2:
    INPUT:
    hello

    OUTPUT:
    SUM = 0 AVG = 0.000000

    TIP: Use Scanner to read input from the user.
    TIP: Use casting when calling the round method since it needs double as a parameter.
    NOTE: Use the method Math.round to round the calculated average (double). The method round returns long.
    NOTE: Be careful about spaces in the printed message.
    NOTE: Be careful if a user types invalid input right away (see example above)
 */

package com.inputcalculator;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        double avg = 0;
        int number;
        boolean hasNextInt;

        while (true) {
            hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                number = scanner.nextInt();
                sum += number;
                count++;
            } else {
                break;
            }

            scanner.nextLine();
        }

        if (count != 0) {
            avg = Math.round((double) sum / (double) count);
        }

        System.out.println("SUM = " + sum + " AVG = " + (int) avg);

        scanner.close();
    }
}
