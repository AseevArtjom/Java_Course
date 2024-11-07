package Service.Hospital;

import Model.Hospital;

public class HospitalPrintableFullImpl implements HospitalPrintable
{
    @Override
    public void printHospital(Hospital hospital) {
        System.out.print("Hospital (" + hospital.getAddress() + ")");
        System.out.println();
    }
}
