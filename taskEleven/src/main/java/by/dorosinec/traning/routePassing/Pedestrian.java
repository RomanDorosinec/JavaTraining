package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 *
 */
public class Pedestrian implements CanPassRoute{

    private double averageSpeed;
    private double cost;

    public Pedestrian() {
        averageSpeed = 5.1;
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