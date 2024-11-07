package Service.Collage;

import Model.Education.Collage;

public class CollagePrintableFullImpl implements CollagePrintable
{
    @Override
    public void printCollage(Collage collage) {
        System.out.println("Collage(" + collage.getAddress() + ")");
        System.out.println("Students count: " + collage.getStudentsCount());
        System.out.println("Specialization: " + collage.getSpecialization());
    }
}
