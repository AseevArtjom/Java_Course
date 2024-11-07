package Model;

import Service.Hospital.HospitalPrintable;

public class Hospital extends House
{
    private HospitalPrintable HospitalPrintable;

    public Hospital(String address,HospitalPrintable hospitalPrintable){
        super(address);
        this.HospitalPrintable = hospitalPrintable;
    }
    public Hospital(HospitalPrintable hospitalPrintable){ this.HospitalPrintable = hospitalPrintable; }

    @Override
    public void printInfo() { HospitalPrintable.printHospital(this); }
    public void setHospitalPrintable(Service.Hospital.HospitalPrintable hospitalPrintable) { HospitalPrintable = hospitalPrintable; }
}
