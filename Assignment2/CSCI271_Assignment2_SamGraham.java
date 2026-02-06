public class CSCI271_Assignment2_SamGraham {

    public static void main(String[] args) {

        // REQUIRED TEST CASES
        Fraction a = new Fraction(16);
        Fraction b = new Fraction(3,5).add(new Fraction(7));
        Fraction c = new Fraction(6,7);
        Fraction result = c.multiply(a.divide(b));

        System.out.println(result); // should print 240/133

        System.out.println(new Fraction(8, -6));   // -4/3
        System.out.println(new Fraction(23, 0));   // Infinity
        System.out.println(new Fraction(-6, 0));   // -Infinity
        System.out.println(new Fraction(0, 0));    // NaN
        System.out.println(new Fraction(7, 1));    // 7
        System.out.println(new Fraction(1,3).pow(-3)); // 27
    }
}

class Fraction {

    private long numerator;
    private long denominator;

    /* Constructors */

    public Fraction(long num, long denom) {
        if (denom == 0) {
            numerator = num;
            denominator = 0;
            return;
        }

        long gcd = gcd(num, denom);
        numerator = num / gcd;
        denominator = denom / gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Fraction(long num) {
        numerator = num;
        denominator = 1;
    }

    /* Accessors */

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    /* Arithmetic Methods */

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
        return new Fraction(
            numerator * f.getNumerator(),
            denominator * f.getDenominator()
        );
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
        if (n == 0) return new Fraction(1);

        if (n < 0) {
            return new Fraction(denominator, numerator).pow(-n);
        }

        return new Fraction(
            (long) Math.pow(numerator, n),
            (long) Math.pow(denominator, n)
        );
    }

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

    /* Helper */

    private long gcd(long a, long b) {
        if (a < 0) a = -a;
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        if (a == 0) return 1;
        return a;
    }
}
