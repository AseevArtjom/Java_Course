package models;

public class LengthConverter {

    public double mmToCm(double mm) {
        return mm / 10;
    }

    public double cmToDm(double cm) {
        return cm / 10;
    }

    public double dmToM(double dm) {
        return dm / 10;
    }

    public double mToKm(double m) {
        return m / 1000;
    }
}
