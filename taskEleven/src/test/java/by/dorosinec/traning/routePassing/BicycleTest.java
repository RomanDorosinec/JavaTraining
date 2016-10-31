package by.dorosinec.traning.routePassing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class Bicycle
 */
public class BicycleTest {
    Bicycle bicycle;

    @Before
    public void setBicycle() {
        bicycle = new Bicycle();
    }

    @Test
    public void positiveFindTime() throws Exception {
        assertEquals(10, bicycle.findTime(185), 0.01);
    }

    @Test
    public void negativeFindTime() throws Exception {
        assertNotEquals(9, bicycle.findTime(185), 0.01);
    }

    @Test
    public void positiveFindCost() throws Exception {
        assertEquals(0, bicycle.findCost(185), 0.01);
    }

    @Test
    public void negativeFindCost() throws Exception {
        assertNotEquals(1, bicycle.findCost(185), 0.01);
    }
}