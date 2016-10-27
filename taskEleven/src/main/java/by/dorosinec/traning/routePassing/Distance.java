package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 *
 */
public class Distance {
    /**
     * This method considers the distance between two neighboring points
     * @param pointOne the first point of the way
     * @param pointTwo the second point of the way
     * @return return distance between coordinates
     */
    public double getDistance(Coordinates pointOne, Coordinates pointTwo) {
        double x1 = pointOne.getCoordinateX();
        double x2 = pointTwo.getCoordinateX();
        double y1 = pointOne.getCoordinateY();
        double y2 = pointTwo.getCoordinateY();

        double xDifference = x2 - x1;
        double yDifference = y2 - y1;
        return Math.sqrt(xDifference * xDifference + yDifference * yDifference);
    }

    /**
     *
     * @param coordinates list with
     * @return get a list of all the distances between neighboring points
     */
    public ArrayList<Double> getAllDistance(ArrayList<Coordinates> coordinates) {
        ArrayList<Double> distance = new ArrayList<Double>();
        for (int i = 1; i < coordinates.size(); i++) {
            distance.add(getDistance(coordinates.get(i - 1), coordinates.get(i)));
        }
        return distance;
    }
}
