package by.dorosinec.traning.triangle;

import java.math.BigDecimal;

/**
 * Class for working with side triangle
 */
public class Triangle {
    /**
     * Checks the existence of a triangle
     * Defines the type of triangle
     * @param a sides triangle
     * @param b sides triangle
     * @param c sides triangle
     * @return the existence of a triangle and its type
     */
    public static String getTriangleType(BigDecimal a, BigDecimal b, BigDecimal c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Numbers must not be null");
        }
        if (a.compareTo(b) == 0 && a.compareTo(c) == 0 && b.compareTo(c) == 0) {
            return "Equilateral triangle";
        }
        // sort three numbers so that a is the smallest and c is the largest
        BigDecimal temp;
        if (a.compareTo(c) > 0) {
            temp = a;
            a = c;
            c = temp;
        }
        if (a.compareTo(b) > 0) {
            temp = a;
            a = b;
            b = temp;
        }
        if (b.compareTo(c) > 0) {
            temp = b;
            b = c;
            c = temp;
        }
        // if sum of the smaller sides is less than the larger side, this is not a triangle
        if (a.add(b).compareTo(c) <= 0) {
            return "Not a triangle";
        }

        // if two larger sides are equal or two smaller sides are equal, it's a isosceles triangle
        if (a.compareTo(b) == 0 || b.compareTo(c) == 0) {
            return "Isosceles triangle";
        }
        return "Regular triangle";
    }
}
