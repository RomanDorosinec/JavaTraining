package by.dorosinec.traning.routePassing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dorosinec on 30.10.2016.
 */
public class PedestrianTest {
    Pedestrian pedestrian;

    @Before
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

    @Test
    public void positiveFindCost() throws Exception {
        assertEquals(0, pedestrian.findCost(51), 0.01);
    }

    @Test
    public void negativeFindCost() throws Exception {
        assertNotEquals(1, pedestrian.findCost(51), 0.01);
    }
}