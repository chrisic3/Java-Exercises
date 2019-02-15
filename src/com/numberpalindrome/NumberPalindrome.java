/*
    Write a method called isPalindrome with one int parameter called number.The method needs to return a boolean.

    It should return true if the number is a palindrome number otherwise it should return false.
    Check the tips below for more info about palindromes.

    Example Input/Output
    isPalindrome(-1221); should return true
    isPalindrome(707); should return true
    isPalindrome(11212); should return false because reverse is 21211 and that is not equal to 11212.

    Tip: What is a Palindrome number? A palindrome number is a number which when reversed is equal to the original
        number. For example: 121, 12321, 1001 etc.

    Tip: Logic to check a palindrome number
    Find the reverse of the given number. Store it in some variable say reverse. Compare the number with reverse.
    If both are the same then the number is a palindrome otherwise it is not.

    Tip: Logic to reverse a number
    Declare and initialize another variable to store the reverse of a number, for example reverse = 0.
    Extract the last digit of the given number by performing modulo division. Store the last digit to some variable
        say lastDigit = num % 10.
    Increase the place value of reverse by one. To increase place value multiply reverse variable by 10
        e.g. reverse = reverse * 10.
    Add lastDigit to reverse.
    Since last digit of num is processed, remove last digit of num. To remove last digit divide num by 10.
    Repeat steps until num is not equal to (or greater than) zero.

    A while loop would be good for this coding exercise.

    Tip: Be careful with reversing a number, you will need a parameter for comparing a reversed number with the
        starting number (parameter).
 */

package com.numberpalindrome;

public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int numberCopy = number;

        while (numberCopy != 0) {
            reverse *= 10;
            reverse += (numberCopy % 10);
            numberCopy /= 10;
        }

        return (number == reverse);
    }
}
