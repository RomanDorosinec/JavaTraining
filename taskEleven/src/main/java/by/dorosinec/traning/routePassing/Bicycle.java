package by.dorosinec.traning.routePassing;

/**
 *
 */
public class Bicycle implements CanPassRoute {

    private double averageSpeed;
    private double cost;

    public Bicycle() {
        averageSpeed = 18.5;
        cost = 0;
    }
    @Override
    public double findTime(double distance) {
        return distance / averageSpeed;
    }

    @Override
    public double findCost(double distance) {
        return cost;
    }
}
