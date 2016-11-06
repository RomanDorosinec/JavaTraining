package by.dorosinec.traning.routePassing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.Assert.assertSame;

/**
 * Class test Itinerary
 */
public class ItineraryTest {
    Itinerary itinerary;
    ArrayList<Coordinates> coordinates;

    @BeforeMethod
    public void setItinerary() {
        itinerary = new Itinerary();
        coordinates = new ArrayList<>();
    }

    @DataProvider(name = "Correct data file")
    public Object[][] array() {
        return new Object[][]{
                {new Coordinates(1, 2), "1 2"},
                {new Coordinates(1.0, 2), "1. 2"},
                {new Coordinates(2, 1.0), "2 1."},
                {new Coordinates(0.2, 2), ".2 2"},
                {new Coordinates(1.2, 0.3), "1.2 .3"}
        };
    }

    @Test(dataProvider = "Correct data file")
    public void positiveValidateLineFileX(Coordinates coordinates, String line) throws Exception {
        assertEquals(itinerary.parseDateFile(line).getCoordinateX(), coordinates.getCoordinateX());
    }

    @Test(dataProvider = "Correct data file")
    public void positiveValidateLineFileY(Coordinates coordinates, String line) throws Exception {
        assertEquals(itinerary.parseDateFile(line).getCoordinateY(), coordinates.getCoordinateY());
    }

    @DataProvider(name = "Invalid data file")
    public Object[][] mass() {
        return new Object[][]{
                {"a 2.3"},
                {"2.3 a"},
                {"2.3"},
                {""},
                {"1,2 2.3"},
                {"1.2 2,3"},
                {"1.1.2 2.3"},
                {"1 1.2 a"},
                {"1 a 1.2"},
                {"/ a 1.2"},
                {"1+1 2+2"}
        };
    }

    @Test(dataProvider = "Invalid data file", expectedExceptions = Exception.class)
    public void negativeValidateLineFile(String line) throws Exception {
        itinerary.parseDateFile(line);
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
        fourthCoordinate.add(new Coordinates(1, Double.NaN));

        ArrayList<Coordinates> fifthCoordinate = new ArrayList<>();
        fifthCoordinate.add(new Coordinates(Double.POSITIVE_INFINITY, 1));
        fifthCoordinate.add(new Coordinates(1, Double.POSITIVE_INFINITY));

        ArrayList<Coordinates> sixthCoordinate = new ArrayList<>();
        sixthCoordinate.add(new Coordinates(Double.NEGATIVE_INFINITY, 1));
        sixthCoordinate.add(new Coordinates(1, Double.NEGATIVE_INFINITY));

        return new Object[][]{{firstCoordinates},
                {secondCoordinates},
                {thirdCoordinates},
                {fourthCoordinate},
                {fifthCoordinate},
                {sixthCoordinate}};
    }

    @Test(dataProvider = "Invalid coordinates", expectedExceptions = Exception.class)
    public void negativeValidateCoordinates(ArrayList<Coordinates> coordinates) throws Exception {
        itinerary.validateCoordinates(coordinates);
    }
}