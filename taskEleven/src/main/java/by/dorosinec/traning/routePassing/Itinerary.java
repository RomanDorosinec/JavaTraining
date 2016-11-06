package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 * This class file data is carried out check and
 * then convert the data to follow up with these data
 */
public class Itinerary {

    ArrayList<Coordinates> coordinates;

    /**
     * Constructor of class, where create ArrayList of coordinates
     */
    public Itinerary() {
        coordinates = new ArrayList<>();
    }

    /**
     * This method adds converted data from file, into coordinates in ArrayList coordinate
     *
     * @param lineDataFile line data from the file
     * @throws Exception if don't have data file
     */
    public void setCoordinates(String lineDataFile) throws Exception {
        coordinates.add(parseDateFile(lineDataFile));
    }

    /**
     * Method for getting ArrayList coordinates
     *
     * @return ArrayList with coordinates of checkpoints
     */
    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    /**
     * Parse string data to double format
     *
     * @param lineDataFile line of arraylist with data from file
     * @return returns a list of the converted file data - coordinates
     */
    public Coordinates parseDateFile(String lineDataFile) throws Exception {
        String arrayDataFile[] = lineDataFile.split(" ");
        if (arrayDataFile.length < 2) {
            throw new IndexOutOfBoundsException("Enter only X coordinate!");
        }

        if (arrayDataFile.length > 2) {
            throw new Exception("Enter more then two coordinate(X, Y)!");
        }
        Coordinates coordinate = new Coordinates(Double.parseDouble(arrayDataFile[0]),
                Double.parseDouble(arrayDataFile[1]));
        return coordinate;
    }

    /**
     * This method for validation data of file
     *
     * @param coordinates arraylist with data from file
     * @throws Exception if have input errors with checkpoints
     */
    public void validateCoordinates(ArrayList<Coordinates> coordinates) throws Exception {
        // Only one checkpoint
        if (coordinates.size() == 1) {
            throw new Exception("Way can't contain only one checkpoint.");
        }
        Coordinates coordinatesFirst = coordinates.get(0);
        Coordinates coordinatesLast = coordinates.get(coordinates.size() - 1);
        // First and last checkpoint are equals
        if ((coordinatesFirst.getCoordinateX() == (coordinatesLast.getCoordinateX())) &&
                coordinatesFirst.getCoordinateY() == coordinatesLast.getCoordinateY()) {
            throw new Exception("First and last checkpoint are equals");
        }
        for (Coordinates coordinate : coordinates) {
            if (Double.isNaN(coordinate.getCoordinateX()) ||
                    coordinate.getCoordinateX() == Double.NEGATIVE_INFINITY ||
                    coordinate.getCoordinateX() == Double.POSITIVE_INFINITY ||
                    Double.isNaN(coordinate.getCoordinateY()) ||
                    coordinate.getCoordinateY() == Double.NEGATIVE_INFINITY ||
                    coordinate.getCoordinateY() == Double.POSITIVE_INFINITY) {
                throw new ArithmeticException("Invalid coordinates!");
            }
        }
    }


}
