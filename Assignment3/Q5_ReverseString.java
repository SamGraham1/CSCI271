/*
 * ------------------------------------------------------------
 * CSCI 271 – Data Structures and Algorithm Complexity
 * Assignment III
 * Question 5 – Recursive String Reversal
 *
 * Name: Sam Graham
 * Date: 2/25/2026
 *
 * Description:
 * This program reads a string S from the user and
 * displays it backwards using recursion.
 *
 * No loops are used inside the recursive function.
 * Full runtime analysis is included below.
 * ------------------------------------------------------------
 */

import java.util.Scanner;

public class Q5_ReverseString {

    /**
     * Recursive function to reverse a string.
     *
     * Base Case:
     * If string length is 0 or 1, return the string.
     *
     * Recursive Case:
     * reverse(S) = reverse(S.substring(1)) + S.charAt(0)
     */
    public static String reverse(String S) {

        if (S.length() <= 1) {   // Base case
            return S;
        }

        return reverse(S.substring(1)) + S.charAt(0);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String S = input.nextLine();

        String reversed = reverse(S);

        System.out.println("Reversed string: " + reversed);

        input.close();
    }

    /*
     * ------------------------------------------------
     * Algorithm Analysis
     * ------------------------------------------------
     *
     * Let n be the length of the string.
     *
     * Each recursive call reduces string size by 1.
     *
     * Recurrence relation:
     *
     * T(n) = T(n - 1) + 1
     * T(1) = 1
     *
     * Expanding:
     *
     * T(n) = T(n - 2) + 2
     * ...
     * T(n) = T(1) + (n - 1)
     *
     * T(n) = n
     *
     * Time Complexity = O(n)
     *
     * Space Complexity:
     *
     * Recursion depth = n
     *
     * Space Complexity = O(n)
     */
}