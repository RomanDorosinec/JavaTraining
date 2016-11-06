package by.dorosinec.traning.routePassing;

/**
 * Class Bus extends Vehicle abstract class, which include can pass route interface
 */
public class Bus extends Vehicle {

    public static final double AVERAGE_SPEED = 90;
    public static final double COST_OF_LITER_FUEL = 2.2;
    public static final double FUEL_CONSUMPTION = 9;
    public static final double NUMBER_OF_PEOPLE = 45;

    private double averageSpeed;
    private double costOfLiterFuel;
    private double fuelConsumption;
    private double numberOfPeople;

    /**
     * Class constructor that sets the value of average speed, travel costs,
     * fuel consumption and number of people in Bus
     */
    public Bus() {
        averageSpeed = AVERAGE_SPEED;
        costOfLiterFuel = COST_OF_LITER_FUEL;
        fuelConsumption = FUEL_CONSUMPTION;
        numberOfPeople = NUMBER_OF_PEOPLE;
    }

    /**
     * Implements method of interface
     * Calculates the time the passage of a predetermined distance a Bus
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
     * Calculates the cost of the passage of a predetermined distance a Bus
     *
     * @param distance the distance between two neighboring points
     * @return returns the value of the route between the nearest checkpoint
     */
    @Override
    public double findCost(double distance) {
        return distance / 100 * fuelConsumption * costOfLiterFuel / numberOfPeople;
    }
}
