package by.dorosinec.traning.routePassing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Class test Interary
 */
public class ItineraryTest {
    Itinerary itinerary;
    ArrayList<Coordinates> coordinates;
    @Before
    public void setItinerary() {
        itinerary = new Itinerary();
        coordinates = new ArrayList<>();
    }

    @Test(expected = NumberFormatException.class)
    public void ParseDateFileFirstFirstElementStringSecondDouble() throws Exception {
        String line = "a 2.3";
        itinerary.parseDateFile(line);
    }

    @Test(expected = Exception.class)
    public void ParseDateFileOnlyOneElement() throws Exception {
        String line = "2.3";
        itinerary.parseDateFile(line);
    }

    @Test(expected = NumberFormatException.class)
    public void ParseDateFileFirst() throws Exception {
        String line = "1,2 2.3";
        itinerary.parseDateFile(line);
    }

    @Test(expected = NumberFormatException.class)
    public void ParseDateFileSecond() throws Exception {
        String line = "1.1.2 2.3";
        itinerary.parseDateFile(line);
    }

    @Test(expected = NumberFormatException.class)
    public void ParseDateFileSecondFirstElementChar() throws Exception {
        String line = "/ 2.3";
        itinerary.parseDateFile(line);
    }

    @Test(expected = Exception.class)
    public void ParseDateFileMoreThenTwoCoordinates() throws Exception {
        String line = "1 1.2 2.3";
        itinerary.parseDateFile(line);
    }

    @Test(expected = Exception.class)
    public void ParseDateFileMoreThenTwoCoordinatesTheFirsTwoDoubleThirdChar() throws Exception {
        String line = "1 1.2 a";
        itinerary.parseDateFile(line);
    }

    @Test(expected = Exception.class)
    public void ParseDateFileMoreThenTwoCoordinatesTheFirsDoubleSecondCharThirdDouble() throws Exception {
        String line = "1 a 1.2";
        itinerary.parseDateFile(line);
    }

    @Test(expected = Exception.class)
    public void ParseDateFileMoreThenTwoCoordinatesTheFirsCharSecondCharThirdDouble() throws Exception {
        String line = "/ a 1.2";
        itinerary.parseDateFile(line);
    }

    @Test(expected = Exception.class)
    public void validateCoordinatesOne() throws Exception {
        Coordinates coordinateFirst = new Coordinates(1.2, 2.3);
        coordinates.add(coordinateFirst);
        itinerary.validateCoordinates(coordinates);
    }

    @Test(expected = Exception.class)
    public void validateCoordinatesFirstAndLast() throws Exception {
        Coordinates coordinateFirst = new Coordinates(1.2, 2.3);
        Coordinates coordinateLast = new Coordinates(1.2, 2.3);
        coordinates.add(coordinateFirst);
        coordinates.add(coordinateLast);
        itinerary.validateCoordinates(coordinates);
    }

    @Test(expected = Exception.class)
    public void validateCoordinatesFirstAndLastAllThree() throws Exception {
        Coordinates coordinateFirst = new Coordinates(1.2, 2.3);
        Coordinates coordinateSecond = new Coordinates(1, 2.3);
        Coordinates coordinateLast = new Coordinates(1.2, 2.3);
        coordinates.add(coordinateFirst);
        coordinates.add(coordinateSecond);
        coordinates.add(coordinateLast);
        itinerary.validateCoordinates(coordinates);
    }
}