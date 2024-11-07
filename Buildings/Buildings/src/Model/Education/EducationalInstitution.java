package Model.Education;

import Model.House;

public abstract class EducationalInstitution extends House {
    private int StudentsCount;
    protected EducationalLevels EducationalLevel;

    public EducationalInstitution(String address,int studentsCount){
        super(address);
        this.StudentsCount = studentsCount;
    }
    public EducationalInstitution(){}

    public int getStudentsCount() {
        return StudentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        StudentsCount = studentsCount;
    }
}
