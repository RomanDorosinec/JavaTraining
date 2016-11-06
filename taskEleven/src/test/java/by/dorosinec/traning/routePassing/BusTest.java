package by.dorosinec.traning.routePassing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Test class Bus
 */
public class BusTest {
    Bus bus;

    @BeforeMethod
    public void setBus() {
        bus = new Bus();
    }

    @Test
    public void positiveFindTime() throws Exception {
        assertEquals(10, bus.findTime(900), 0.01);
    }

    @Test
    public void negativeFindTime() throws Exception {
        assertNotEquals(11, bus.findTime(800), 0.01);
    }

    @Test
    public void positiveFindCost() throws Exception {
        assertEquals(4.4, bus.findCost(1000), 0.01);
    }

    @Test
    public void negativeFindCost() throws Exception {
        assertNotEquals(9, bus.findCost(1000), 0.01);
    }

    @DataProvider(name = "validate NaN and Infinity findTime")
    public Object[][] arrayOne() {
        return new Object[][]{{Double.NaN},
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY}};
    }

    @Test(dataProvider = "validate NaN and Infinity findTime", expectedExceptions = Exception.class)
    public void negativeTestElementsTime(Double elements) throws Exception {
        bus.findTime(elements);
    }

    @DataProvider(name = "validate NaN and Infinity findCost")
    public Object[][] arrayTwo() {
        return new Object[][]{{Double.NaN},
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY}};
    }

    @Test(dataProvider = "validate NaN and Infinity findCost", expectedExceptions = Exception.class)
    public void negativeTestElementsCost(Double elements) throws Exception {
        bus.findCost(elements);
    }
}