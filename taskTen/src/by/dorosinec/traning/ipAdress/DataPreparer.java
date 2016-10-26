package by.dorosinec.traning.ipAdress;

import java.util.ArrayList;

/**
 * Receiving sheet object server, and looks for the maximum ping
 */
public class DataPreparer {
    /**
     * Ping is looking for the maximum and adds one more field that says about this
     * @param dataToPrepare
     * @return
     */
    public ArrayList<DataToExport> prepare(ArrayList<Server> dataToPrepare) {
        ArrayList<DataToExport> prepareData = new ArrayList<>();
        int maxPing = dataToPrepare.get(0).getPing();
        for (Server server : dataToPrepare) {
            if (maxPing < server.getPing()) {
                maxPing = server.getPing();
            }
        }
        for (Server server : dataToPrepare) {
            prepareData.add(new DataToExport(server, maxPing == server.getPing()));
        }
        return prepareData;
    }
}
