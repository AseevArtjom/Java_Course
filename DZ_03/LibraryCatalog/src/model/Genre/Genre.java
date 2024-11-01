package model.Genre;

public class Genre {
    protected String Name;

    public Genre(String name){
        this.Name = name;
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }

}
