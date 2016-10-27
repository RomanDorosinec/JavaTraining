package by.dorosinec.traning.routePassing;

import java.util.ArrayList;

/**
 * This class file data is carried out check and
 * then convert the data to follow up with these data
 */
public class ParseAndValidate {
    /**
     * Parse string data to double format
     *
     * @param dataFile arraylist with data from file
     * @return returns a list of the converted file data - coordinates
     */
    public ArrayList<Coordinates> parseDateFile(ArrayList<String> dataFile) {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        try {
            validateDataFile(dataFile);
            for (String s : dataFile) {
                String arrayDataFile[] = s.split(" ", 2);
                coordinates.add(new Coordinates(Double.parseDouble(arrayDataFile[0]),
                        Double.parseDouble(arrayDataFile[1])));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        return coordinates;
    }

    /**
     * This method for validation data of file
     *
     * @param dataFile arraylist with data from file
     * @throws Exception if have input errors with checkpoints
     */
    public void validateDataFile(ArrayList<String> dataFile) throws Exception {
        // Empty file
        if (dataFile.size() == 0) {
            throw new Exception("Not input coordinates.");
        }

        // Only one checkpoint
        if (dataFile.size() == 1) {
            throw new Exception("Way can't contain only one checkpoint.");
        }

        // First and last checkpoint are equals
        if (dataFile.get(0).equals(dataFile.get(dataFile.size() - 1))) {
            throw new Exception("First and last checkpoint are equals");
        }
    }
}
