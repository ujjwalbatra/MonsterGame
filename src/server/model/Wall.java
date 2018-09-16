package server.model;

public class Wall extends Stationary {

    public Wall(int xCorrdinate, int yCoordinate) {
        super(xCorrdinate, yCoordinate, false);
    }

    @Override
    public void draw() {
        System.out.print("W");
    }
}