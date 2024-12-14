package models;

public enum Currency {
    DOLLAR(1.0),EURO(1.05),POUND(1.28),YEN(151.76);

    private final Double Exchange_rate;
    Currency(Double ex_rate){
        this.Exchange_rate = ex_rate;
    }
    public Double getValue(){
        return Exchange_rate;
    }
}
