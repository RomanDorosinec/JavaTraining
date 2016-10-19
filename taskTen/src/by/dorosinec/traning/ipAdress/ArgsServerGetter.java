package by.dorosinec.traning.ipAdress;

import java.util.ArrayList;

/**
 * Getting command args
 */
public class ArgsServerGetter {
    /**
     * Reading from a command line and write servers in arraylist
     * @param args command line
     * @return array list with servers
     */
    public ArrayList<Server> getServers(String[] args) {
        ArrayList<Server> servers = new ArrayList<>();
        for (int i = 0; i < args.length; i++){
            servers.add(new Server(args[i]));
        }
        return servers;
    }
}
