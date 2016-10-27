package by.dorosinec.traning.routePassing;

import java.io.*;
import java.util.ArrayList;

/**
 * It reads data from a file
 */
public class ReadDataFile {
    /**
     * Reading from a file and write date in the arraylist
     *
     * @param file file with coordinates
     * @return arraylist with data from file
     * @throws IOException file does not exist
     */
    public ArrayList<String> readAllLines(File file) throws IOException {
        ArrayList<String> dateFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String nextString;
        while ((nextString = reader.readLine()) != null) {
            dateFile.add(nextString);
        }
        return dateFile;
    }
}
