package by.dorosinec.traning.routePassing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class Bus
 */
public class BusTest {
    Bus bus;

    @Before
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

}