package by.dorosinec.traning.routePassing;

/**
 * Class Car extends Vehicle abstract class, which include can pass route interface
 */
public class Car extends Vehicle {

    public double averageSpeed;
    public double costOfLiterFuel;
    public double fuelConsumption;

    /**
     * Class constructor that sets the value of average speed, travel costs and fuel consumption
     */
    public Car() {
        averageSpeed = 90;
        costOfLiterFuel = 2.3;
        fuelConsumption = 9;
    }

    /**
     * Implements method of interface
     * Calculates the time the passage of a predetermined distance a Car
     *
     * @param distance the distance between two neighboring points
     * @return returns the travel time between the nearest checkpoint
     */
    @Override
    public double findTime(double distance) {
        return distance / averageSpeed;
    }

    /**
     * Implements method of interface
     * Calculates the cost of the passage of a predetermined distance a Car
     *
     * @param distance the distance between two neighboring points
     * @return returns the value of the route between the nearest checkpoint
     */
    @Override
    public double findCost(double distance) {
        return distance / 100 * fuelConsumption * costOfLiterFuel;
    }
}
