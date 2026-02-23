/*
 * ------------------------------------------------------------
 * CSCI 271 – Data Structures and Algorithm Complexity
 * Assignment #: [Put Assignment Number Here]
 * Question 1 – Recursive String Length
 *
 * Name: Sam Graham
 * Date: 2/25/2026
 *
 * Description:
 * This program reads in a string S from the user and displays the length of S. In doing
 * so, the program will use a recursive function that takes S as an argument and returns the number
 * of characters in S recursively! Solutions to this question using a loop are not acceptable! In
 * addition, calculate the running time of this function and show your work in details
 * ------------------------------------------------------------
 */

import java.util.Scanner;

public class Q1_StringLength {

    
    /**
     * Recursive function to compute the length of a string.
     *
     * Base Case:
     * If the string is empty, return 0.
     *
     * Recursive Case:
     * Return 1 + length of the string without its first character.
     */
    public static int length(String s) {
        if (s.length() == 0) { //base case
            return 0;
        }

        return 1 + length(s.substring(1)); //recursive step
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        int result = length(s);

        System.out.println("The length of \"" + s + "\" is " + length(s));

        scanner.close();
    }

    /*
     * ------------------------------------------------
     * Algorithm Analysis
     * ------------------------------------------------
     *
     * Time Complexity:
     *
     * Let n be the length of the input string.
     *
     * We count the number of recursive calls as the key operation.
     *
     * The function makes one recursive call on a string of size n - 1.
     *
     * Recurrence relation:
     *
     * T(n) = T(n - 1) + 1     for n > 0
     * T(0) = 1                (base case)
     *
     * Expanding:
     *
     * T(n) = T(n - 2) + 2
     * T(n) = T(n - 3) + 3
     * ...
     * T(n) = T(0) + n
     *
     * Since T(0) is constant:
     *
     * T(n) = n + 1
     *
     * Therefore:
     *
     * Time Complexity = O(n)
     *
     *
     * Space Complexity:
     *
     * Fixed part:
     * - Local variables (constant space)
     *
     * Variable part:
     * - Recursion stack depth is n + 1
     *
     * Therefore:
     *
     * Space Complexity = O(n)
     */
}
