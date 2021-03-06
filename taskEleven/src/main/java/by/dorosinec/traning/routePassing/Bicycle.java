package by.dorosinec.traning.routePassing;

/**
 * Class pedestrian implements can pass route interface
 */
public class Bicycle implements CanPassRoute {

    private static final double AVERAGESPEED = 18.5;
    private static final double COST = 0;

    private double averageSpeed;
    private double cost;

    /**
     * Class constructor that sets the value of average speed and travel costs
     */
    public Bicycle() {
        averageSpeed = AVERAGESPEED;
        cost = COST;
    }

    /**
     * Implements method of interface
     * Calculates the time the passage of a predetermined distance a Bicycle
     *
     * @param distance the distance between two neighboring points
     * @return returns the travel time between the nearest checkpoint
     */
    @Override
    public double findTime(double distance) {
        if (Double.isNaN(distance) || distance == Double.NEGATIVE_INFINITY || distance == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Invalid time!");
        }
        return distance / averageSpeed;
    }

    /**
     * Implements method of interface
     * Calculates the cost of the passage of a predetermined distance a Bicycle
     *
     * @param distance the distance between two neighboring points
     * @return returns the value of the route between the nearest checkpoint
     */
    @Override
    public double findCost(double distance) {
        return cost;
    }
}
