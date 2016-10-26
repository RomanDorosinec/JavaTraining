package by.dorosinec.traning.routePassing;

import java.io.*;
import java.util.ArrayList;

/**
 * It reads data from a file
 */
public class ReadDataFile {
    /**
     * Reading from a file and write date coordinates in the arraylist
     * @param file file with coordinates
     * @return arraylist<string></string> with data from file
     * @throws IOException file does not exist
     */
    public ArrayList<String> getCoordinate(File file) throws IOException {
        ArrayList<String> dateFile = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String nextString;
        while ((nextString = reader.readLine()) != null) {
            dateFile.add(nextString);
        }
        return dateFile;
    }
}
