/*
    Create a program using arrays that sorts a list of integers in descending order.
    Descending order is highest value to lowest.
    In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
    ultimately have an array with 106,81,26, 15, 5 in it.
    Set up the program so that the numbers to sort are read in from the keyboard.
    Implement the following methods - getIntegers, printArray, and sortIntegers
    getIntegers returns an array of entered integers from keyboard
    printArray prints out the contents of the array
    and sortIntegers should sort the array and return a new array containing the sorted numbers
    you will have to figure out how to copy the array elements from the passed array into a new
    array and sort them and return the new sorted array.
 */

package com.sortarray;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    int[] intArray = getIntegers(5);
	    printArray(sortIntegers(intArray));

	    intArray = getIntegers(10);
	    printArray(sortIntegers(intArray));
    }

    private static int[] getIntegers(int number) {
        int[] intArray = new int[number];

        System.out.println("Enter " + number + " integers:");

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return intArray;
    }

    private static int[] sortIntegers(int[] intArray) {
        int[] sortedArray = new int[intArray.length];

        // copy array to new array to sort
        for (int i = 0; i < intArray.length; i++) {
            sortedArray[i] = intArray[i];
        }

        // insertion sort: i = 1 because array[0] is already called sorted
        for (int i = 1; i < sortedArray.length; i++) {
            int currentPosition = i;
            int temp = sortedArray[i];

            while (currentPosition >= 1 && sortedArray[currentPosition - 1] < temp) {
                sortedArray[currentPosition] = sortedArray[currentPosition - 1];
                sortedArray[currentPosition - 1] = temp;
                currentPosition--;
            }
        }

        return sortedArray;
    }

    private static void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
