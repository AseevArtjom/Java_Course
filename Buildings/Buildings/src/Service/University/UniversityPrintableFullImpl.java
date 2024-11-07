package Service.University;

import Model.Education.University;

public class UniversityPrintableFullImpl implements UniversityPrintable
{
    @Override
    public void printUniversity(University university) {
        System.out.println("Collage(" + university.getAddress() + ")");
        System.out.println("Students count: " + university.getStudentsCount());
        System.out.println("Specialization: " + university.getSpecialization());
    }
}
