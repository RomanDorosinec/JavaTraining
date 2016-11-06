package by.dorosinec.traning.routePassing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Test class Pedestrian
 */
public class PedestrianTest {
    Pedestrian pedestrian;

    @BeforeMethod
    public void setPedestrian() {
        pedestrian = new Pedestrian();
    }

    @Test
    public void positiveFindTime() throws Exception {
        assertEquals(10, pedestrian.findTime(51), 0.01);
    }

    @Test
    public void negativeFindTime() throws Exception {
        assertNotEquals(11, pedestrian.findTime(51), 0.01);
    }

    @DataProvider(name = "validate NaN and Infinity findTime")
    public Object[][] arrayOne() {
        return new Object[][]{{Double.NaN},
                {Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY}};
    }

    @Test(dataProvider = "validate NaN and Infinity findTime", expectedExceptions = Exception.class)
    public void negativeTestElementsTime(Double elements) throws Exception {
        pedestrian.findTime(elements);
    }
}