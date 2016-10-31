package by.dorosinec.traning.routePassing;


import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.util.ArrayList;

/**
 * Main class of program. Entrance point to the program
 */
public class Main {
    public static final String FILE_NAME = "coordinates.txt";

    /**
     * Reads date from file. Create objects of program and
     * shows statistic (time and cost) for each mode of transportation
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            ReceivingFromFile receivingFromFile = new ReceivingFromFile();
            Itinerary itinerary = new Itinerary();
            receivingFromFile.readAllLines(itinerary, new File(FILE_NAME));
            ArrayList<CanPassRoute> transport = new ArrayList<>();
            transport.add(new Pedestrian());
            transport.add(new Bicycle());
            transport.add(new Car());
            transport.add(new Bus());
            Double totalDistance = new Distance().getTotalDistance(itinerary.getCoordinates());
            for (Object transports : transport) {
                System.out.println(getStatistic((CanPassRoute) transports, totalDistance));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Make string that contains time spend for passage of a predetermined distance and
     * it's cost in according to the fuel price.
     *
     * @param transport type of transport
     * @param distance  the distance between two neighboring points
     * @return string with name of type of transport, distance, spend time of travel and cost of travel
     */
    private static String getStatistic(CanPassRoute transport, double distance) {
        return transport.getClass().getSimpleName() + "(distance: " + distance + ") spend " +
                transport.findTime(distance) + " hours and cost " +
                transport.findCost(distance) + " USD";
    }
}
