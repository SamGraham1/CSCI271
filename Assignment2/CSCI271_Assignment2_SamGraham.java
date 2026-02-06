/*************************************************************************
* Assignment 2 for CSCI 271-001 Spring 2026
*
* Author: Sam Graham
* OS: Windows 11
* Compiler: javac 25.0.1
* Date: January 29, 2026
*
* Purpose
* The purpose of this program is to design a data structure that offers
* exact arithmetic calculations. Floating-point division is avoided by
* representing values as fractions and implementing arithmetic operations
* on those fractions.
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
*   instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
*   or any unauthorized sources, including the Internet.
* - Any source code or documentation used from other sources has
*   been clearly cited in the comments.
* - I have not designed this program to interfere with grading code.
*
* Sam Graham
* (WID not included as instructed)
********************************************************************/

public class CSCI271_Assignment2_SamGraham {

    public static void main(String[] args) {

    System.out.println("===== TASK 1: Constructors & Normalization =====");

    System.out.println("Test 1.1: new Fraction(6, -24)  // expect -1/4");
    System.out.println(new Fraction(6, -24));

    System.out.println("Test 1.2: new Fraction(0, 8)    // expect 0");
    System.out.println(new Fraction(0, 8));

    System.out.println("Test 1.3: new Fraction(7)       // expect 7");
    System.out.println(new Fraction(7));

    System.out.println("\n===== TASK 2: toString Special Cases =====");

    System.out.println("Test 2.1: new Fraction(23, 0)   // expect Infinity");
    System.out.println(new Fraction(23, 0));

    System.out.println("Test 2.2: new Fraction(-6, 0)   // expect -Infinity");
    System.out.println(new Fraction(-6, 0));

    System.out.println("Test 2.3: new Fraction(0, 0)    // expect NaN");
    System.out.println(new Fraction(0, 0));

    System.out.println("Test 2.4: new Fraction(7, 1)    // expect 7");
    System.out.println(new Fraction(7, 1));

    System.out.println("\n===== TASK 3: Arithmetic Operations =====");

    System.out.println("Test 3.1: 1/3 + 1/6             // expect 1/2");
    System.out.println(new Fraction(1,3).add(new Fraction(1,6)));

    System.out.println("Test 3.2: 3/4 - 1/4             // expect 1/2");
    System.out.println(new Fraction(3,4).subtract(new Fraction(1,4)));

    System.out.println("Test 3.3: 2/3 * 3/4             // expect 1/2");
    System.out.println(new Fraction(2,3).multiply(new Fraction(3,4)));

    System.out.println("Test 3.4: 2/3 / 4/5             // expect 5/6");
    System.out.println(new Fraction(2,3).divide(new Fraction(4,5)));

    System.out.println("\n===== TASK 3: Negate =====");

    System.out.println("Test 4.1: negate(5/7)           // expect -5/7");
    System.out.println(new Fraction(5,7).negate());

    System.out.println("Test 4.2: negate(Infinity)      // expect -Infinity");
    System.out.println(new Fraction(5,0).negate());

    System.out.println("Test 4.3: negate(NaN)           // expect NaN");
    System.out.println(new Fraction(0,0).negate());

    System.out.println("\n===== TASK 3: Power =====");

    System.out.println("Test 5.1: (2/3)^2               // expect 4/9");
    System.out.println(new Fraction(2,3).pow(2));

    System.out.println("Test 5.2: (5/9)^0               // expect 1");
    System.out.println(new Fraction(5,9).pow(0));

    System.out.println("Test 5.3: (1/3)^-3              // expect 27");
    System.out.println(new Fraction(1,3).pow(-3));

    System.out.println("\n===== TASK 4: Full Assignment Example =====");

    Fraction a = new Fraction(16);
    Fraction b = new Fraction(3,5).add(new Fraction(7));
    Fraction c = new Fraction(6,7);
    Fraction results = c.multiply(a.divide(b));

    System.out.println("Final Example Result            // expect 240/133");
    System.out.println(results);
}
}

/*******************************************************************
* Fraction class
********************************************************************/
class Fraction {

    private long numerator;
    private long denominator;

    /********************* Constructors ************************/

    public Fraction(long num, long denom) {

        // Handle denominator = 0
        if (denom == 0) {
            numerator = num;
            denominator = 0;
            return;
        }

        long gcd = gcd(num, denom);
        numerator = num / gcd;
        denominator = denom / gcd;

        // Ensure denominator is positive
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Fraction(long num) {
        numerator = num;
        denominator = 1;
    }

    /********************* Accessors ************************/

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    /********************* Arithmetic Methods ************************/

    public Fraction add(Fraction f) {
        long num = numerator * f.getDenominator()
                 + denominator * f.getNumerator();
        long denom = denominator * f.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction subtract(Fraction f) {
        return add(f.negate());
    }

    public Fraction multiply(Fraction f) {
        long num = numerator * f.getNumerator();
        long denom = denominator * f.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction divide(Fraction f) {
        return new Fraction(
            numerator * f.getDenominator(),
            denominator * f.getNumerator()
        );
    }

    public Fraction negate() {
        return new Fraction(-numerator, denominator);
    }

    public Fraction pow(int n) {

        if (n == 0) {
            return new Fraction(1);
        }

        if (n < 0) {
            return new Fraction(denominator, numerator).pow(-n);
        }

        return new Fraction(
            (long) Math.pow(numerator, n),
            (long) Math.pow(denominator, n)
        );
    }

    /********************* toString ************************/

    @Override
    public String toString() {

        if (denominator == 0) {
            if (numerator == 0) return "NaN";
            return numerator > 0 ? "Infinity" : "-Infinity";
        }

        if (denominator == 1) {
            return String.valueOf(numerator);
        }

        return numerator + "/" + denominator;
    }

    /********************* Helper Methods ************************/

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
