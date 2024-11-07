package Service.School;

import Model.Education.School;

public class SchoolPrintableFullIml implements SchoolPrintable
{
    @Override
    public void printSchool(School school) {
        System.out.println("School(" + school.getAddress() + ")");
        System.out.println("Students count: " + school.getStudentsCount());
    }
}
