package by.dorosinec.traning.routePassing;

/**
 *
 */
public class Bus extends Vehicle {

    private double averageSpeed;
    public double costOfLiterFuel;
    public double fuelConsumption;
    private double numberOfPeople;

    public Bus() {
        averageSpeed = 80;
        costOfLiterFuel = 2.5;
        fuelConsumption = 15;
        numberOfPeople = 45;
    }

    @Override
    public double findTime(double distance) {
        return distance / averageSpeed;
    }

    @Override
    public double findCost(double distance) {
        return distance / 100 * fuelConsumption * costOfLiterFuel / numberOfPeople;
    }
}
