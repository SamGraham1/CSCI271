/*************************************************************************
* Assignment 2 for CSCI 271-001 Spring 2026
*
* Author: Sam Graham
* OS: Windows 11
* Compiler: javac 25.0.1
* Date: January 29, 2026
*
* Purpose
* The purpose of this program is to design a data structure that that 
*offers exact arithmetics calcuations. We need to avoid float number 
*division by keeping the values as fractions, 
*which means that we need several operations to implement the data type 
*and implement the operations needed to perform the desired arithmetic manipulations. 
*
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* <Sam Graham>
* Was told not to include WID
********************************************************************/
Public class CSCI271_Assignment2_SamGraham{
    


    public static void main(String[] args){
    
    
    }
}

class Fraction {
    private long numerator;
    private long denominator;


/********************* Constructors ************************/


    public Fraction(long num, long denom)
    {
    // make sure denominator is not 0
        if (denom == 0)
        {
            numerator = num;
            denominator = 0;
            return;
        }
    // find the greatest common divisor
        long gcd = gcd(num, denom);
        numerator = num / gcd;
        denominator = denom / gcd;

    // make sure denominator is positive
        if (denominator < 0)
        {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Fraction(long num)
    {   
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
}

/********************* Arithmetic Methods ************************/

/**
 * This method takes another Fraction object as a parameter and returns a new Fraction object that is the result of adding the two fractions together.
 * 
 * To add two fractions, we need to find a common denominator, which is the product of the two denominators. Then, we can add the two numerators together, 
 * multiplying the first numerator by the second denominator and the second numerator by the first denominator. This is because when we add two fractions, 
 * we are essentially adding the number of equal parts represented by the numerators, and the denominator tells us how many parts make up the whole.
 * 
 * The new Fraction object is created with the resulting numerator and denominator.
 * 
 * @param f The Fraction object to be added to this object.
 * @return A new Fraction object that is the result of adding the two fractions together.
 */
public Fraction add(Fraction f){
    long num = numerator * f.getDenominator() + denominator * f.getNumerator();
    long denom = denominator * f.getDenominator();
    return new Fraction(num, denom);
}
// subtraction
public Fraction subtract(Fraction f) {
    return add(f.negate());
}
 
// multiplication
public Fraction multiply(Fraction f) {
    long num = numerator * f.getNumerator();
    long denom = denominator * f.getDenominator();
    return new Fraction(num, denom);
}

// division
public Fraction divide(Fraction f) {
    return multiply(f.reciprocal());
}

// negate
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
    }
