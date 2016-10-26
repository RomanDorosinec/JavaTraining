package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 * Created by Dorosinec on 26.10.2016.
 */
public class ParseAndValidate {
    public ArrayList<Coordinates> parseDateFile(ArrayList<String> dataFile) {
        ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();
        for (String s : dataFile){
            String arrayDataFile[] = s.split(" ", 2);
            coordinates.add(new Coordinates(Double.parseDouble(arrayDataFile[0]),
                                            Double.parseDouble(arrayDataFile[1])));
        }
        return coordinates;
    }
    /*public String validateDataFile(ArrayList<String> dataFile) {
        if (dataFile.size() != 0) {

        } else {
            return "No data in the file";
        }
        return "";
    }*/
}
