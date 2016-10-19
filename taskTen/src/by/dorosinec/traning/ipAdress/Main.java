package by.dorosinec.traning.ipAdress;


import java.io.File;
import java.util.ArrayList;

/**
 * Entry point into the program
 */
public class Main {
    public static final String HTML_FILE_NAME = "serverIp.html";
    public static final String FILE_IP_ADRESSA = "ipAdressa.txt";

    /**
     * Entry point in the program
     * @param args command line argument
     */
    public static void main(String[] args) {
        try {
            ArrayList<Server> servers;
            // if lack of command line arguments that are taken from the file Address
            if (args.length == 0) {
                FileServerGetter fileServerGetter = new FileServerGetter();
                servers = fileServerGetter.getServers(new File(FILE_IP_ADRESSA));
            } else {
                ArgsServerGetter argsServerGetter = new ArgsServerGetter();
                servers = argsServerGetter.getServers(args);
            }
            SimulatePing simulatePing = new SimulatePing();
            simulatePing.pingServers(servers);
            DataPreparer dataPreparer = new DataPreparer();
            ArrayList<DataToExport> dataToExports = dataPreparer.prepare(servers);
            HtmlTable htmlTable = new HtmlTable();
            htmlTable.saveToFile(new File(HTML_FILE_NAME), dataToExports);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
