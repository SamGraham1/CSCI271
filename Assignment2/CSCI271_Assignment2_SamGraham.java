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

        // Test cases
        Fraction a = new Fraction(16);
        Fraction b = new Fraction(3, 5).add(new Fraction(7));
        Fraction c = new Fraction(6, 7);

        Fraction result = c.multiply(a.divide(b));
        System.out.println(result);

        Fraction test = new Fraction(1, 3);
        System.out.println(test.pow(-3));
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
