package Model.Education;

import Service.School.SchoolPrintable;

public class School extends EducationalInstitution{
    private SchoolPrintable SchoolPrintable;

    public School(String address,int studentscount,SchoolPrintable schoolPrintable){
        super(address,studentscount);
        this.EducationalLevel = EducationalLevels.PRIMARY;
        this.SchoolPrintable = schoolPrintable;
    }
    public School(SchoolPrintable schoolPrintable){
        this.EducationalLevel = EducationalLevels.PRIMARY;
        this.SchoolPrintable = schoolPrintable;
    }

    @Override
    public void printInfo() { SchoolPrintable.printSchool(this); }
    public void setSchoolPrintable(Service.School.SchoolPrintable schoolPrintable) { SchoolPrintable = schoolPrintable; }
}
