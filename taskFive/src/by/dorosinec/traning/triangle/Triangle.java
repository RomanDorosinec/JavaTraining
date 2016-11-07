package by.dorosinec.traning.triangle;

import java.math.BigDecimal;

/**
 * Class for working with side triangle
 */
public class Triangle {

    private BigDecimal sideA;
    private BigDecimal sideB;
    private BigDecimal sideC;

    /**
     * @param sideA first side of triangle
     * @param sideB second side of triangle
     * @param sideC third side of triangle
     * @throws Exception if side is zero, less then zero or null
     */
    public Triangle(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws Exception {
        validateSides(sideA);
        validateSides(sideB);
        validateSides(sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Defines the type of triangle and existence triangle
     *
     * @return the existence of a triangle and its type
     */
    public String getTriangleType() throws Exception {
        existenceTriangle();

        //if all sides are equals, it's a equilateral triangle
        if (sideA.compareTo(sideB) == 0 &&
                sideA.compareTo(sideC) == 0 &&
                sideB.compareTo(sideC) == 0) {
            return "Equilateral triangle";
        }

        // if two sides are equal, it's a isosceles triangle
        if (sideA.compareTo(sideB) == 0 ||
                sideB.compareTo(sideC) == 0 ||
                sideA.compareTo(sideC) == 0) {
            return "Isosceles triangle";
        }
        return "Regular triangle";
    }

    /**
     * If the sum of two sides of a triangle is less than a third, the triangle does not exist
     *
     * @throws Exception triangle does not exist
     */
    private void existenceTriangle() throws Exception {
        if (sideA.add(sideB).compareTo(sideC) <= 0 ||
                sideA.add(sideC).compareTo(sideB) <= 0 ||
                sideC.add(sideB).compareTo(sideA) <= 0) {
            throw new Exception("Not a triangle");
        }
    }

    /**
     * Check if side is zero, less then zero or null
     *
     * @param side one side of the triangle
     * @throws Exception if have invalid side
     */
    private void validateSides(BigDecimal side) throws Exception {

        // Side is null
        if (side == null) {
            throw new Exception("Side must not be null");
        }

        // Side is zero or less then zero
        if (side.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new Exception("Side must not be less or equals zero");
        }
    }
}