package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 *
 */
public class ParseAndValidate {
    public ArrayList<Coordinates> parseDateFile(ArrayList<String> dataFile) {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        for (String s : dataFile){
            String arrayDataFile[] = s.split(" ", 2);
            coordinates.add(new Coordinates(Double.parseDouble(arrayDataFile[0]),
                                            Double.parseDouble(arrayDataFile[1])));
        }
        return coordinates;
    }

    /*public void validateDataFile(ArrayList<String> dataFile) throws Exception {
        if (dataFile.size() == 0) {
            throw new SimpleException("sdf");
        }
    }*/
}
