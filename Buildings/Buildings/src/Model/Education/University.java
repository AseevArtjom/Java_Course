package Model.Education;

import Service.University.UniversityPrintable;

public class University extends EducationalInstitution
{
    private String Specialization;
    private UniversityPrintable UniversityPrintable;

    public University(String address,int studentcount,String specialization,UniversityPrintable universityPrintable)
    {
        super(address,studentcount);
        this.EducationalLevel = EducationalLevels.HIGHER;
        this.Specialization = specialization;
        this.UniversityPrintable = universityPrintable;
    }

    public University(UniversityPrintable universityPrintable){
        this.EducationalLevel = EducationalLevels.HIGHER;
        this.UniversityPrintable = universityPrintable;
    }

    @Override
    public void printInfo() { UniversityPrintable.printUniversity(this); }
    public void setUniversityPrintable(UniversityPrintable universityPrintable){ this.UniversityPrintable = universityPrintable; }

    public String getSpecialization() {
        return Specialization;
    }
    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }
}
