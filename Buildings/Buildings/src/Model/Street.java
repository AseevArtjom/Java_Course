package Model;

import java.util.ArrayList;
import java.util.List;

public class Street
{
    private String Name;
    private List<House> BuildingList;

    public Street(String name,List<House>buildingList){
        this.Name = name;
        this.BuildingList = buildingList;
    }

    public Street(String name){
        this.Name = name;
        BuildingList = new ArrayList<>();
    }

    public Street(){
        BuildingList = new ArrayList<>();
    }

    public void addBuilding(House house){
        this.BuildingList.add(house);
    }

    public void removeBuilding(House house){
        this.BuildingList.remove(house);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<House> getBuildingList() {
        return BuildingList;
    }

    public void setBuildingList(List<House> buildingList) {
        BuildingList = buildingList;
    }
}
