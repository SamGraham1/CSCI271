/*
 * ------------------------------------------------------------
 * CSCI 271 – Data Structures and Algorithm Complexity
 * Assignment #: 3
 * Question 2 – Recursive Character Count
 *
 * Name: Sam Graham
 * Date: 2/25/2026
 *
 * Description:
 * This program reads a string and a character from the user.
 * It recursively counts how many times the character appears
 * in the string.
 *
 * The solution uses recursion only (no loops inside the method).
 * Full runtime and space complexity analysis is included below.
 * ------------------------------------------------------------
 */

import java.util.Scanner;

public class Q2_CountCharacter {

    /**
     * Recursive method to count occurrences of character c in string s.
     *
     * Base Case:
     * If the string is empty, return 0.
     *
     * Recursive Case:
     * If first character equals c, return 1 + recursive call.
     * Otherwise return recursive call only.
     */
    public static int countChar(String s, char c) {
        if (s.length() == 0) {   // Base case
            return 0;
        }

        if (s.charAt(0) == c) {
            return 1 + countChar(s.substring(1), c);
        } else {
            return countChar(s.substring(1), c);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = input.nextLine();

        System.out.print("Enter a character: ");
        char c = input.next().charAt(0);

        int result = countChar(s, c);

        System.out.println("The character '" + c + "' appears "
                + result + " times in \"" + s + "\".");

        input.close();
    }

    /*
     * ------------------------------------------------
     * Algorithm Analysis
     * ------------------------------------------------
     *
     * Time Complexity:
     *
     * Let n be the length of the string.
     *
     * Each recursive call reduces the string size by 1.
     * Each call performs a constant amount of work O(1).
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
     * Therefore:
     *
     * T(n) = n + 1
     *
     * Time Complexity = O(n)
     *
     *
     * Space Complexity:
     *
     * Fixed Part:
     * - Local variables (constant space)
     *
     * Variable Part:
     * - Recursion stack depth is n + 1
     *
     * Space Complexity = O(n)
     */
}