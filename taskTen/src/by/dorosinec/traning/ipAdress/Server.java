package by.dorosinec.traning.ipAdress;

/**
 *
 */
public class Server {

    private String ip;
    private int ping;

    public Server(String adress) {
        this.ip = adress;
    }

    public String getIp() {
        return ip;
    }

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }
}
