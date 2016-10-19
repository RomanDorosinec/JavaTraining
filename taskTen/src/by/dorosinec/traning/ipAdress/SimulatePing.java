package by.dorosinec.traning.ipAdress;

import java.util.ArrayList;
import java.util.Random;

/**
 * Modeling server poll
 */
public class SimulatePing {
    /**
     * adds a random value pings servers
     * @param servers list servers
     */
    public void pingServers(ArrayList<Server> servers) {
        for (Server server : servers) {
            server.setPing(new Random().nextInt(490) + 10);
        }
    }
}
