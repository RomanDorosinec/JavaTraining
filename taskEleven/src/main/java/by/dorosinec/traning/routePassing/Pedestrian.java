package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 * Created by Dorosinec on 26.10.2016.
 */
public class Pedestrian {
    public ArrayList<Double> getDistance(ArrayList<Coordinates> coordinates) {
        ArrayList<Double> distance = new ArrayList<Double>();
        for (int i = 0; i < coordinates.size(); i++) {
            double firstMember = (coordinates.get(i).getCoordinateX() - coordinates.get(i).getCoordinateY()) *
                         (coordinates.get(i).getCoordinateX() - coordinates.get(i).getCoordinateY());
            double secondMember = 0;
            for (int j = i + 1; j < coordinates.size(); j++) {
                secondMember = (coordinates.get(j).getCoordinateX() - coordinates.get(j).getCoordinateY()) *
                        (coordinates.get(j).getCoordinateX() - coordinates.get(j).getCoordinateY());

                i = j;
            }
            distance.add(Math.sqrt(firstMember + secondMember));
        }
        return distance;
    }
}
