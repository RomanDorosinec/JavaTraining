package by.dorosinec.traning.routePassing;

/**
 * Class Bus extends Vehicle abstract class, which include can pass route interface
 */
public class Bus extends Vehicle {

    private double averageSpeed;
    public double costOfLiterFuel;
    public double fuelConsumption;
    private double numberOfPeople;

    /**
     * Class constructor that sets the value of average speed, travel costs,
     * fuel consumption and number of people in Bus
     */
    public Bus() {
        averageSpeed = 80;
        costOfLiterFuel = 2.5;
        fuelConsumption = 15;
        numberOfPeople = 45;
    }

    /**
     *Implements method of interface
     * Calculates the time the passage of a predetermined distance a Bus
     * @param distance the distance between two neighboring points
     * @return returns the travel time between the nearest checkpoint
     */
    @Override
    public double findTime(double distance) {
        return distance / averageSpeed;
    }

    /**
     * Implements method of interface
     * Calculates the cost of the passage of a predetermined distance a Bus
     * @param distance the distance between two neighboring points
     * @return returns the value of the route between the nearest checkpoint
     */
    @Override
    public double findCost(double distance) {
        return distance / 100 * fuelConsumption * costOfLiterFuel / numberOfPeople;
    }
}
