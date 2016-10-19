package by.dorosinec.traning.ipAdress;

import java.io.*;
import java.util.ArrayList;

/**
 * Getting File Information
 */
public class FileServerGetter {
    /**
     * Reading from a file and write servers in arraylist
     * @param file file with address
     * @return array list with servers
     * @throws IOException file does not exist
     */
    public ArrayList<Server> getServers(File file) throws IOException {
        ArrayList<Server> servers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("ipAdressa.txt"));
        String nextString;
        while ((nextString = reader.readLine()) != null) {
            servers.add(new Server(nextString));
        }
        return servers;
    }
}
