package by.dorosinec.traning.routePassing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class Test
 */
public class CarTest {
    Car car;

    @Before
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
}