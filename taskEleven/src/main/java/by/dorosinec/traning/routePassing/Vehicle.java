package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 *
 */
public abstract class Vehicle implements CanPassRoute {

    public abstract double findTime(double distance);

    public abstract double findCost(double distance);
}
