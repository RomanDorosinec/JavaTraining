package by.dorosinec.traning.routePassing;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Dorosinec on 26.10.2016.
 */
public class Main {
    public static final String FILE_NAME = "coordinates.txt";
    public static void main(String[] args) {
        try {
            ReadDataFile readDateFile = new ReadDataFile();
            ArrayList<String> dateFile = readDateFile.getCoordinate(new File(FILE_NAME));
            ParseAndValidate parseAndValidate = new ParseAndValidate();
            Pedestrian pedestrian = new Pedestrian();
            pedestrian.getDistance(parseAndValidate.parseDateFile(dateFile)).get(0);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
