package by.dorosinec.traning.routePassing;

/**
 * Interface of can pass route. All kinds of movement should  implement this interface
 * Provide methods to find time (hours) and find cost (USD)
 */
public interface CanPassRoute {
    /**
     * Calculates the time the passage of a predetermined distance of a certain mode of transport
     *
     * @param distance the distance between two neighboring points
     * @return returns the travel time between the nearest checkpoint
     */
    double findTime(double distance);

    /**
     * Calculates the cost of the passage of a predetermined distance a certain mode of transport
     *
     * @param distance the distance between two neighboring points
     * @return returns the value of the route between the nearest checkpoint
     */
    double findCost(double distance);
}
