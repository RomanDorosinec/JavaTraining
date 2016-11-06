package by.dorosinec.traning.routePassing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test class Distance
 */
public class DistanceTest {
    Distance distance;
    ArrayList<Coordinates> coordinates;

    @Before
    public void set() {
        distance = new Distance();
        coordinates = new ArrayList<>();
    }

    @Test
    public void positiveGetTotalDistance() throws Exception {
        Coordinates coordinateOne = new Coordinates(2, 2);
        Coordinates coordinateTwo = new Coordinates(6, 5);
        coordinates.add(coordinateOne);
        coordinates.add(coordinateTwo);
        assertEquals(5, distance.getTotalDistance(coordinates), 0.001);
    }

    @Test
    public void negativeGetTotalDistance() throws Exception {
        Coordinates coordinateOne = new Coordinates(2, 2);
        Coordinates coordinateTwo = new Coordinates(6, 5);
        coordinates.add(coordinateOne);
        coordinates.add(coordinateTwo);
        assertNotEquals(90, distance.getTotalDistance(coordinates), 0.001);
    }

    @Test
    public void getTotalDistanceFirstAndSecondEqualsThreadDifferent() throws Exception {
        Coordinates coordinateFirst = new Coordinates(1.2, 2.3);
        Coordinates coordinateSecond = new Coordinates(1.2, 2.3);
        Coordinates coordinateLast = new Coordinates(1, 2.3);
        coordinates.add(coordinateFirst);
        coordinates.add(coordinateSecond);
        coordinates.add(coordinateLast);
        assertEquals(0.19999, distance.getTotalDistance(coordinates), 0.001);
    }

    @Test
    public void getTotalDistanceSecondAndThreadEqualsFirstDifferent() throws Exception {
        Coordinates coordinateFirst = new Coordinates(1, 2.3);
        Coordinates coordinateSecond = new Coordinates(1.2, 2.3);
        Coordinates coordinateLast = new Coordinates(1.2, 2.3);
        coordinates.add(coordinateFirst);
        coordinates.add(coordinateSecond);
        coordinates.add(coordinateLast);
        assertEquals(0.19999, distance.getTotalDistance(coordinates), 0.001);
    }
}