package Service.Residential;

import Model.Residential;

public class ResidentialPrintableFullImpl implements ResidentialPrintable
{
    @Override
    public void printResidential(Residential residential) {
        System.out.println("Residential: " + "(" + residential.getAddress() + ")");
        System.out.print("Residents count: " + residential.getResidentsCount());
        System.out.println();
    }
}
