package Model;

import Service.Residential.ResidentialPrintable;

import java.util.Scanner;

public class Residential extends House{
    private ResidentialPrintable ResidentialPrintable;
    private int ResidentsCount;
    public Residential(String address,
                       int residentsCount,
                       ResidentialPrintable residentialPrintable){
        super(address);
        this.ResidentsCount = residentsCount;
        this.ResidentialPrintable = residentialPrintable;
    }

    public  Residential(ResidentialPrintable residentialPrintable){ this.ResidentialPrintable = residentialPrintable; }

    @Override
    public void printInfo() {
        ResidentialPrintable.printResidential(this);
    }

    public int getResidentsCount() {
        return ResidentsCount;
    }

    public void setResidentsCount(int residentsCount) {
        ResidentsCount = residentsCount;
    }
}
