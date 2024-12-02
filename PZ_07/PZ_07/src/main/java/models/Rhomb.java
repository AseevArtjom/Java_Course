package models;

public class Rhomb implements Shape {
    private final double diagonal_1;
    private final double diagonal_2;

    public Rhomb(double diagonal1, double diagonal2) {
        this.diagonal_1 = diagonal1;
        this.diagonal_2 = diagonal2;
    }

    @Override
    public double calculateArea() {
        return 0.5 * diagonal_1 * diagonal_2;
    }
}
