package by.dorosinec.traning.ipAdress;

/**
 *
 */
public class DataToExport {
    private String ip;
    private String ping;
    private boolean toColor;

    public DataToExport(Server server, boolean toColor) {
        this.ip = server.getIp();
        this.ping = String.valueOf(server.getPing());
        this.toColor = toColor;
    }

    public String getIp() {
        return ip;
    }

    public String getPing() {
        return ping;
    }

    public boolean getColor() {
        return toColor;
    }
}
