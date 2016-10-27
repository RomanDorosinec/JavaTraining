package by.dorosinec.traning.routePassing;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class Main {
    public static final String FILE_NAME = "coordinates.txt";
    public static void main(String[] args) {
        try {
            ArrayList<String> dateFile = new ReadDataFile().readAllLines(new File(FILE_NAME));
            ArrayList<Double> distances = new Distance().getAllDistance(new ParseAndValidate().parseDateFile(dateFile));
            ArrayList<CanPassRoute> transport = new ArrayList<>();
            transport.add(new Pedestrian());
            transport.add(new Bicycle());
            transport.add(new Car());
            transport.add(new Bus());
            for (Object transports : transport) {
                for (Double way : distances) {
                    System.out.println(getStatistic((CanPassRoute) transports, way));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getStatistic(CanPassRoute transport, double distance) {
        return transport.getClass().getSimpleName() + "(distance: " + distance + ") spend " +
               transport.findTime(distance) + " hours and cost " +
               transport.findCost(distance) + " USD";
    }
}
