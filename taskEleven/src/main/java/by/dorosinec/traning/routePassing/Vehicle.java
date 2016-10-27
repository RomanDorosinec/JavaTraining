package by.dorosinec.traning.routePassing;

/**
 * Abstract class of vehicle transport. Class implements Move interface.
 */
public abstract class Vehicle implements CanPassRoute {
    /**
     * Calculates the time the passage of a predetermined distance of a certain mode of transport
     *
     * @param distance the distance between two neighboring points
     * @return returns the travel time between the nearest checkpoint
     */
    public abstract double findTime(double distance);

    /**
     * Calculates the cost of the passage of a predetermined distance a certain mode of transport
     *
     * @param distance the distance between two neighboring points
     * @return returns the value of the route between the nearest checkpoint
     */
    public abstract double findCost(double distance);
}
