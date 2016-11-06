package by.dorosinec.traning.routePassing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Test class Bicycle
 */
public class BicycleTest {
    Bicycle bicycle;

    @BeforeMethod
    public void setBicycle() {
        bicycle = new Bicycle();
    }

    @Test
    public void positiveFindTime() throws Exception {
        assertEquals(10, bicycle.findTime(185), 0.01);
    }

    @Test
    public void negativeFindTime() throws Exception {
        assertNotEquals(bicycle.findTime(185), 9, 0.01);
    }

    @DataProvider(name = "validate NaN and Infinity findTime")
    public Object[][] arrayOne() {
        return new Object[][]{{Double.NaN},
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY}};
    }

    @Test(dataProvider = "validate NaN and Infinity findTime", expectedExceptions = Exception.class)
    public void negativeTestElementsTime(Double elements) throws Exception {
        bicycle.findTime(elements);
    }
}