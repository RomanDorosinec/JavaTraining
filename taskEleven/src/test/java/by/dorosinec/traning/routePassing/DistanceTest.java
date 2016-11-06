package by.dorosinec.traning.routePassing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.ServiceConfigurationError;

/**
 * Test class Distance
 */
public class DistanceTest {
    Distance distance;
    ArrayList<Coordinates> coordinates;

    @BeforeMethod
    public void set() {
        distance = new Distance();
        coordinates = new ArrayList<>();
    }

    @DataProvider(name = "Different coordinates")
    public Object[][] mass() {
        ArrayList<Coordinates> firstCoordinates = new ArrayList<>();
        firstCoordinates.add(new Coordinates(1.2, 2.3));
        firstCoordinates.add(new Coordinates(1.2, 2.3));
        firstCoordinates.add(new Coordinates(1, 2.3));

        ArrayList<Coordinates> secondCoordinates = new ArrayList<>();
        secondCoordinates.add(new Coordinates(1, 2.3));
        secondCoordinates.add(new Coordinates(1.2, 2.3));
        secondCoordinates.add(new Coordinates(1.2, 2.3));

        ArrayList<Coordinates> thirdCoordinates = new ArrayList<>();
        thirdCoordinates.add(new Coordinates(2, 2));
        thirdCoordinates.add(new Coordinates(6, 5));

        return new Object[][]{{0.19999, firstCoordinates},
                {0.19999, secondCoordinates},
                {5.0, thirdCoordinates}};
    }

    @Test(dataProvider = "Different coordinates")
    public void positiveGetTotalDistance(Double extend, ArrayList<Coordinates> coordinates) throws Exception {
        assertEquals(extend, distance.getTotalDistance(coordinates), 0.001);
    }

    @DataProvider(name = "Validate")
    public Object[][] mas() {
        ArrayList<Coordinates> firstCoordinates = new ArrayList<>();
        firstCoordinates.add(new Coordinates(2, 2));
        firstCoordinates.add(new Coordinates(6, 5));

        return new Object[][]{{90, firstCoordinates}};
    }

    @Test(dataProvider = "Validate", expectedExceptions = Exception.class)
    public void negativeGetTotalDistance(Double extend, ArrayList<Coordinates> coordinates) throws Exception {
        assertNotEquals(extend, distance.getTotalDistance(coordinates), 0.001);
    }

    @DataProvider(name = "Invalid coordinates")
    public Object[][] coordinate() {
        ArrayList<Coordinates> firstCoordinates = new ArrayList<>();
        firstCoordinates.add(new Coordinates(1.2, 2.3));

        ArrayList<Coordinates> secondCoordinates = new ArrayList<>();
        secondCoordinates.add(new Coordinates(1.2, 2.3));
        secondCoordinates.add(new Coordinates(1.2, 2.3));

        ArrayList<Coordinates> thirdCoordinates = new ArrayList<>();
        thirdCoordinates.add(new Coordinates(1.2, 2.3));
        thirdCoordinates.add(new Coordinates(6, 5));
        thirdCoordinates.add(new Coordinates(1.2, 2.3));

        ArrayList<Coordinates> fourthCoordinate = new ArrayList<>();
        fourthCoordinate.add(new Coordinates(Double.NaN, 1));
        fourthCoordinate.add(new Coordinates(1.1, Double.NaN));

        ArrayList<Coordinates> fifthCoordinate = new ArrayList<>();
        fifthCoordinate.add(new Coordinates(Double.POSITIVE_INFINITY, 1));
        fifthCoordinate.add(new Coordinates(1.1, Double.POSITIVE_INFINITY));

        ArrayList<Coordinates> sixthCoordinate = new ArrayList<>();
        sixthCoordinate.add(new Coordinates(Double.NEGATIVE_INFINITY, 1));
        sixthCoordinate.add(new Coordinates(1.1, Double.NEGATIVE_INFINITY));

        return new Object[][]{{firstCoordinates},
                {secondCoordinates},
                {thirdCoordinates},
                {fourthCoordinate},
                {fifthCoordinate},
                {sixthCoordinate}};
    }

    @Test(dataProvider = "Invalid coordinates", expectedExceptions = Exception.class)
    public void negativeValidateCoordinates(ArrayList<Coordinates> coordinates) throws Exception {
        distance.getTotalDistance(coordinates);
    }
}