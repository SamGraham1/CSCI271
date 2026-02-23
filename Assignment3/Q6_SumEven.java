/*
 * ------------------------------------------------------------
 * CSCI 271 – Data Structures and Algorithm Complexity
 * Assignment III
 * Question 6 – Recursive Sum of Even Numbers
 *
 * Name: Sam Graham
 * Date: 2/25/2026
 *
 * Description:
 * This program reads a list of integers from the user,
 * stores them in an array A, and recursively computes
 * the sum of all even integers using sumEven().
 *
 * The recursive function does NOT print anything.
 * Full runtime analysis is included below.
 * ------------------------------------------------------------
 */

import java.util.Scanner;

public class Q6_SumEven {

    /**
     * Recursive function to sum even numbers in first n elements of array A.
     *
     * Base Case:
     * If n == 0, return 0.
     *
     * Recursive Case:
     * If A[n-1] is even, add it to recursive call.
     */
    public static int sumEven(int[] A, int n) {

        if (n == 0) {   // Base case
            return 0;
        }

        if (A[n - 1] % 2 == 0) {
            return A[n - 1] + sumEven(A, n - 1);
        } else {
            return sumEven(A, n - 1);
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

        int result = sumEven(A, size);

        System.out.println("Sum of even numbers: " + result);

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
     * Each call performs constant work (mod check + addition).
     *
     * Recurrence relation:
     *
     * T(n) = T(n - 1) + 1     for n > 0
     * T(0) = 1
     *
     * Expanding:
     *
     * T(n) = T(n - 2) + 2
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