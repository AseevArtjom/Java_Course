package models;

public class CurrencyConverter {
    private static final double EUR = 0.85;
    private static final double GBP = 0.75;
    private static final double JPY = 110.0;

    public double convertUsdToEur(double usd) {
        return usd * EUR;
    }

    public double convertUsdToGbp(double usd) {
        return usd * GBP;
    }

    public double convertUsdToJpy(double usd) {
        return usd * JPY;
    }
}