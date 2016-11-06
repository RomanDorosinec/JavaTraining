package by.dorosinec.traning.routePassing;

import java.io.*;
import java.util.ArrayList;

/**
 * It reads data from a file
 */
public class ReceivingFromFile {
    /**
     * Reading from a file and add each line from file in itinerary
     *
     * @param itinerary object which will contain ArrayList with checkpoints
     * @param file      file with coordinates
     * @return arraylist with data from file
     * @throws IOException file does not exist
     */
    public Itinerary readAllLines(Itinerary itinerary, File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String nextString  = reader.readLine();
        validateDataOfFile(nextString);
        while ((nextString) != null) {
            itinerary.setCoordinates(nextString);
            nextString  = reader.readLine();
        }
        return itinerary;
    }

    /**
     * Validate contain fail of elements
     * @param lineFile line of file
     * @throws Exception not input coordinates
     */
    public void validateDataOfFile(String lineFile) throws Exception {
        // Empty file
        if (lineFile == null) {
            throw new Exception("Not input coordinates.");
        }
    }
}
