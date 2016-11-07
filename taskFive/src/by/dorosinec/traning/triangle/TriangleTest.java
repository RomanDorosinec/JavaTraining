package by.dorosinec.traning.triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Test class Triangle
 */
public class TriangleTest {
    @DataProvider(name = "Valid regular triangle type")
    public Object[][] validRegularTriangle() {
        return new Object[][]{
                {BigDecimal.valueOf(9), BigDecimal.valueOf(10), BigDecimal.valueOf(11)}
        };
    }

    @Test(dataProvider = "Valid regular triangle type")
    public void getTriangleTypeRegular(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws Exception {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(triangle.getTriangleType(), "Regular triangle");
    }

    @DataProvider(name = "Valid equilateral triangle type")
    public Object[][] validEquilateralTriangle() {
        return new Object[][]{
                {BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(10)}
        };
    }

    @Test(dataProvider = "Valid equilateral triangle type")
    public void getTriangleTypeEquilateral(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws Exception {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(triangle.getTriangleType(), "Equilateral triangle");
    }

    @DataProvider(name = "Valid isosceles triangle triangle")
    public Object[][] validIsoscelesTriangle() {
        return new Object[][]{
                {BigDecimal.valueOf(12), BigDecimal.valueOf(12), BigDecimal.valueOf(15)},
                {BigDecimal.valueOf(12), BigDecimal.valueOf(15), BigDecimal.valueOf(12)},
                {BigDecimal.valueOf(15), BigDecimal.valueOf(12), BigDecimal.valueOf(12)}
        };
    }

    @Test(dataProvider = "Valid isosceles triangle triangle")
    public void getTriangleTypeIsosceles(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws Exception {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(triangle.getTriangleType(), "Isosceles triangle");
    }

    @DataProvider(name = "Invalid params of sides")
    public Object[][] invalidParams() {
        return new Object[][]{
                {null, null, null},
                {null, null, BigDecimal.valueOf(12)},
                {null, BigDecimal.valueOf(12), null},
                {BigDecimal.valueOf(12), null, null},
                {null, BigDecimal.valueOf(13), BigDecimal.valueOf(12)},
                {BigDecimal.valueOf(13), null, BigDecimal.valueOf(12)},
                {BigDecimal.valueOf(13), BigDecimal.valueOf(12), null},
                {BigDecimal.valueOf(-10), BigDecimal.valueOf(13), BigDecimal.valueOf(12)},
                {BigDecimal.valueOf(10), BigDecimal.valueOf(-13), BigDecimal.valueOf(12)},
                {BigDecimal.valueOf(10), BigDecimal.valueOf(13), BigDecimal.valueOf(-12)},
                {BigDecimal.valueOf(-10), BigDecimal.valueOf(-13), BigDecimal.valueOf(-12)},
                {BigDecimal.valueOf(100), BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(100), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(100)},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(0), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(0)}
        };
    }

    @Test(dataProvider = "Invalid params of sides", expectedExceptions = Exception.class)
    public void getTriangleTypeException(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) throws Exception {
        new Triangle(sideA, sideB, sideC).getTriangleType();
    }
}