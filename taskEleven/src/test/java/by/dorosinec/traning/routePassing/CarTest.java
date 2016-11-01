package by.dorosinec.traning.routePassing;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;

/**
 * Test class Test
 */
public class CarTest {
    Car car;

    @BeforeMethod
    public void setCar() {
        car = new Car();
    }

    @Test
    public void positiveFindTime() throws Exception {
        assertEquals(1, car.findTime(90), 0.01);
    }

    @Test
    public void negativeFindTime() throws Exception {
        assertNotEquals(15, car.findTime(90), 0.01);
    }

    @Test
    public void positiveFindCost() throws Exception {
        assertEquals(198, car.findCost(1000), 0.01);
    }

    @Test
    public void negativeFindCost() throws Exception {
        assertNotEquals(20, car.findCost(1000), 0.01);
    }

    @DataProvider(name = "validate NaN and Infinity findTime")
    public Object[][] arrayOne() {
        return new Object[][]{{Double.NaN},
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY}};
    }

    @org.testng.annotations.Test(dataProvider = "validate NaN and Infinity findTime", expectedExceptions = Exception.class)
    public void negativeTestElementsTime(Double elements) throws Exception {
        car.findTime(elements);
    }

    @DataProvider(name = "validate NaN and Infinity findCost")
    public Object[][] arrayTwo() {
        return new Object[][]{{Double.NaN},
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY}};
    }

    @org.testng.annotations.Test(dataProvider = "validate NaN and Infinity findCost", expectedExceptions = Exception.class)
    public void negativeTestElementsCost(Double elements) throws Exception {
        car.findCost(elements);
    }
}