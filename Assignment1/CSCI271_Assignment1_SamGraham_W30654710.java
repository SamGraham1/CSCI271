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
    * Description: This is where the program starts. It asks the user
    * for all the scores (assignments, tests, midterm, and final exam),
    * creates a StudentGrade object to hold these scores, and then
    * calculates and prints the final numeric grade.
    *
    * Parameters: args - command line arguments (not used)
    *
    * Pre: All entered scores should be numbers between 0 and 100
    *
    * Post: The final grade is printed to the console
    *
    * Returns: nothing
    *
    * Called by: nothing (this is the entry point)
    * Calls: StudentGrade.calculateG()
    ************************************************************************/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int NUM_ASSIGNMENTS = 7;
        final int NUM_TESTS = 7;

        double[] assignments = new double[NUM_ASSIGNMENTS];
        double[] tests = new double[NUM_TESTS];

        // ---- Input assignments ----
        System.out.println("Enter " + NUM_ASSIGNMENTS + " assignment scores (0-100):");
        for (int i = 0; i < NUM_ASSIGNMENTS; i++) {
            System.out.print("Assignment " + (i + 1) + ": ");
            assignments[i] = input.nextDouble();
        }

        // ---- Input tests ----
        System.out.println("\nEnter " + NUM_TESTS + " test scores (0-100):");
        for (int i = 0; i < NUM_TESTS; i++) {
            System.out.print("Test " + (i + 1) + ": ");
            tests[i] = input.nextDouble();
        }

        // ---- Input midterm and final ----
        System.out.print("\nEnter Midterm score (0-100): ");
        double midterm = input.nextDouble();

        System.out.print("Enter Final Exam score (0-100): ");
        double finalExam = input.nextDouble();

        // ---- Create a StudentGrade object ----
        StudentGrade student = new StudentGrade(assignments, tests, midterm, finalExam);

        // ---- Calculate and display the final grade ----
        double finalGrade = student.calculateG();
        System.out.printf("\nFinal numeric grade (G) = %.2f\n", finalGrade);

        input.close();
    }
}

/*************************************************************************
 * StudentGrade class
 *
 * Description: Stores a student's scores and provides methods to calculate
 * the exam/test portion (E) and the final grade (G) according to the syllabus.
 *************************************************************************/
class StudentGrade {
    private double[] assignments;
    private double[] tests;
    private double midterm;
    private double finalExam;

    /*****************************Constructor****************************
    * Description: Creates a StudentGrade object with all relevant scores
    * 
    * Parameters:
    * - assignments: array of assignment scores
    * - tests: array of test scores
    * - midterm: score of the midterm
    * - finalExam: score of the final exam
    *
    * Pre: Scores should be valid numbers between 0-100
    *
    * Post: The object is ready to calculate final grades
    *
    * Returns: nothing
    *
    * Called by: main
    ************************************************************************/
    public StudentGrade(double[] assignments, double[] tests, double midterm, double finalExam) {
        this.assignments = assignments;
        this.tests = tests;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    /*****************************calculateE****************************
    * Description: Computes the portion of the grade based on tests and exams
    *
    * Parameters: none
    *
    * Pre: Scores have been entered
    *
    * Post: Returns the weighted exam/test score (E)
    *
    * Returns: double - the exam/test portion of the grade
    *
    * Called by: calculateG
    ************************************************************************/
    private double calculateE() {
        double T = Arrays.stream(tests).average().orElse(0);
        return 0.4 * finalExam + 0.2 * midterm + 0.1 * T;
    }

