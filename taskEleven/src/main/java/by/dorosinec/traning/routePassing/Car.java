package by.dorosinec.traning.routePassing;

/**
 *
 */
public class Car extends Vehicle {

    public double averageSpeed;
    public double costOfLiterFuel;
    public double fuelConsumption;

    public Car() {
        averageSpeed = 90;
        costOfLiterFuel = 2.3;
        fuelConsumption = 9;
    }

    @Override
    public double findTime(double distance) {
        return distance / averageSpeed;
    }

    @Override
    public double findCost(double distance) {
        return distance / 100 * fuelConsumption * costOfLiterFuel;
    }
}
