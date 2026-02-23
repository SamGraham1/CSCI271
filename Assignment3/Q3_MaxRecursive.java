/*
 * ------------------------------------------------------------
 * CSCI 271 – Data Structures and Algorithm Complexity
 * Assignment III
 * Question 3 – Recursive Maximum in Array
 *
 * Name: Sam Graham
 * Date: 2/25/2026
 *
 * Description:
 * This program reads a list of integers from the user,
 * stores them in an array A, and finds the maximum value
 * using a recursive function max().
 *
 * No loops are used inside the recursive function.
 * Full runtime analysis is included below.
 * ------------------------------------------------------------
 */

import java.util.Scanner;

public class Q3_MaxRecursive {

    /**
     * Recursive function to find maximum element in first n elements of array A.
     *
     * Base Case:
     * If n == 1, return A[0].
     *
     * Recursive Case:
     * Compare A[n-1] with max(A, n-1).
     */
    public static int max(int[] A, int n) {

        if (n == 1) {     // Base case
            return A[0];
        }

        int previousMax = max(A, n - 1);

        if (A[n - 1] > previousMax) {
            return A[n - 1];
        } else {
            return previousMax;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = input.nextInt();

        int[] A = new int[size];

        System.out.println("Enter the integers:");

        for (int i = 0; i < size; i++) {
            A[i] = input.nextInt();
        }

        int result = max(A, size);

        System.out.println("The maximum value is: " + result);

        input.close();
    }

    /*
     * ------------------------------------------------
     * Algorithm Analysis
     * ------------------------------------------------
     *
     * Let n be the number of elements in the array.
     *
     * Each recursive call reduces n by 1.
     * Each call performs constant work (one comparison).
     *
     * Recurrence relation:
     *
     * T(n) = T(n - 1) + 1       for n > 1
     * T(1) = 1                  (base case)
     *
     * Expanding:
     *
     * T(n) = T(n - 2) + 2
     * T(n) = T(n - 3) + 3
     * ...
     * T(n) = T(1) + (n - 1)
     *
     * Since T(1) is constant:
     *
     * T(n) = n
     *
     * Therefore:
     *
     * Time Complexity = O(n)
     *
     * Space Complexity:
     *
     * Fixed part:
     * - Array storage O(n)
     * - Local variables O(1)
     *
     * Variable part:
     * - Recursion stack depth = n
     *
     * Space Complexity = O(n)
     */
}