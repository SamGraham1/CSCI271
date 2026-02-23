/*
 * ------------------------------------------------------------
 * CSCI 271 – Data Structures and Algorithm Complexity
 * Assignment III
 * Question 4 – Recursive Digit Counter
 *
 * Name: Sam Graham
 * Date: February 2026
 *
 * Description:
 * This program reads a long integer N and a digit D
 * from the user and recursively counts how many times
 * D appears in N.
 *
 * NOTE: N is declared as long as instructed.
 * No loops are used inside the recursive function.
 * Full runtime analysis is included below.
 * ------------------------------------------------------------
 */

import java.util.Scanner;

public class Q4_DigitCounter {

    /**
     * Recursive function to count occurrences of digit D in N.
     *
     * Base Case:
     * If N == 0, return 0.
     *
     * Recursive Case:
     * Compare last digit (N % 10) with D.
     * Then call function on N / 10.
     */
    public static int countDigit(long N, int D) {

        if (N == 0) {        // Base case
            return 0;
        }

        int lastDigit = (int)(N % 10);

        if (lastDigit == D) {
            return 1 + countDigit(N / 10, D);
        } else {
            return countDigit(N / 10, D);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a long integer N: ");
        long N = input.nextLong();

        System.out.print("Enter a single digit D (0-9): ");
        int D = input.nextInt();

        int result = countDigit(N, D);

        System.out.println("Digit " + D + " appears "
                + result + " times in " + N + ".");

        input.close();
    }

    /*
     * ------------------------------------------------
     * Algorithm Analysis
     * ------------------------------------------------
     *
     * Let n be the number of digits in N.
     *
     * Each recursive call removes one digit (N / 10).
     * Each call performs constant work (mod, division, comparison).
     *
     * Recurrence relation:
     *
     * T(n) = T(n - 1) + 1      for n > 0
     * T(0) = 1                 (base case)
     *
     * Expanding:
     *
     * T(n) = T(n - 2) + 2
     * T(n) = T(n - 3) + 3
     * ...
     * T(n) = T(0) + n
     *
     * Therefore:
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