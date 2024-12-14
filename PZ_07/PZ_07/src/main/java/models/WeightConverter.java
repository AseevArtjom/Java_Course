package models;

public class WeightConverter {

    public double mgToG(double mg) {
        return mg / 1000;
    }

    public double gToKg(double g) {
        return g / 1000;
    }

    public double kgToT(double kg) {
        return kg / 1000;
    }

    public double tToCentner(double t) {
        return t * 10;
    }
}