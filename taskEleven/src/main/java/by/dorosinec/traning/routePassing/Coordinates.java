package by.dorosinec.traning.routePassing;

/**
 * Class coordinates, which contain two fields - coordinates(X, Y) of checkpoints
 */
public class Coordinates {
    private double coordinateX;
    private double coordinateY;

    /**
     * Constructor of Coordinates, which appoint values of field
     *
     * @param X first coordinate of checkpoint
     * @param Y second coordinate of checkpoint
     */
    public Coordinates(double X, double Y) {
        this.coordinateX = X;
        this.coordinateY = Y;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }
}
