package Model.Education;

import Service.Collage.CollagePrintable;

public class Collage extends EducationalInstitution
{
    private String Specialization;
    private CollagePrintable CollagePrintable;

    public Collage(String address,int studentscount,String specialization,CollagePrintable collagePrintable){
        super(address,studentscount);
        this.EducationalLevel = EducationalLevels.SECONDARY;
        this.Specialization = specialization;
        this.CollagePrintable = collagePrintable;
    }

    public Collage(CollagePrintable collagePrintable){
        this.EducationalLevel = EducationalLevels.SECONDARY;
        this.CollagePrintable = collagePrintable;
    }

    @Override
    public void printInfo() { CollagePrintable.printCollage(this); }
    public void setCollagePrintable(Service.Collage.CollagePrintable collagePrintable) { CollagePrintable = collagePrintable; }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }
}
