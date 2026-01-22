/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
*   instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
*   or any unauthorized sources, including the Internet, either
*   modified or unmodified.
* - If any source code or documentation used in my program was
*   obtained from other sources, like a textbook or course notes,
*   I have clearly indicated that with a proper citation in the
*   comments of my program.
* - I have not designed this program in such a way as to defeat or
*   interfere with the normal operation of the supplied grading code.
*
* Sam Graham
* W30654710
********************************************************************/

/*************************************************************************
 * Project 1 for CSCI 271-001 Spring 2026
 *
 * Author: Sam Graham
 * OS: Ubuntu Linux 21.10
 * Compiler: javac 25.0.1
 * Date: January 23, 2026
 *
 * Purpose:
 * This program calculates the final numeric grade for a student based
 * on assignment scores, test scores, midterm, and final exam according
 * to the grading scheme in the course syllabus. It uses a StudentGrade
 * class to implement an Abstract Data Type (ADT), separating application
 * logic from grade calculation.
 *
 *************************************************************************/

import java.util.*;

public class CSCI271_Assignment1_SamGraham_W30654710 {

    /*****************************main****************************
    * Description: Prompts the user to enter scores for assignments,
    *              tests, midterm, and final exam, creates a StudentGrade
    *              object, then calculates and displays the final numeric grade.
    *
    * Parameters: args (input): command line arguments (not used)
    *
    * Pre: All scores entered must be numeric and between 0 and 100
    *
    * Post: Final grade (G) is calculated and displayed to the user
    *
    * Returns: none
    *
    * Called by: none
    * Calls: StudentGrade.calculateG()
    ************************************************************************/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int NUM_ASSIGNMENTS = 7;
        final int NUM_TESTS = 7;

        double[] assignments = new double[NUM_ASSIGNMENTS];
        double[] tests = new double[NUM_TESTS];

        // ---- Input: Assignments ----
        System.out.println("Enter " + NUM_ASSIGNMENTS + " assignment scores (0-100):");
        for (int i = 0; i < NUM_ASSIGNMENTS; i++) {
            System.out.print("Assignment " + (i + 1) + ": ");
            assignments[i] = input.nextDouble();
        }

        // ---- Input: Tests ----
        System.out.println("\nEnter " + NUM_TESTS + " test scores (0-100):");
        for (int i = 0; i < NUM_TESTS; i++) {
            System.out.print("Test " + (i + 1) + ": ");
            tests[i] = input.nextDouble();
        }

        // ---- Input: Midterm and Final ----
        System.out.print("\nEnter Midterm score (0-100): ");
        double midterm = input.nextDouble();

        System.out.print("Enter Final Exam score (0-100): ");
        double finalExam = input.nextDouble();

        // ---- Create ADT object ----
        StudentGrade student = new StudentGrade(assignments, tests, midterm, finalExam);

        // ---- Calculate final grade ----
        double finalGrade = student.calculateG();

        // ---- Output ----
        System.out.printf("\nFinal numeric grade (G) = %.2f\n", finalGrade);

        input.close();
    }
}
