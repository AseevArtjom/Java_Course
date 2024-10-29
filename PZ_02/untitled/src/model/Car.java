package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Car {
    private String Name;
    private String Manufacturer;
    private Date Release;
    private float EngineCapacity;

    public Car(){}

    public Car(String name,String manufacturer,Date release,float engineCapacity){
        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Release = release;
        this.EngineCapacity = engineCapacity;
    }

    public void Input(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Title : ");
        this.Name = scanner.nextLine();

        System.out.print("Manufacturer : ");
        this.Manufacturer = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        while (true) {
            System.out.print("Release (dd-MM-yyyy): ");
            String dateInput = scanner.nextLine();
            try {
                this.Release = formatter.parse(dateInput);
                break;
            } catch (ParseException e) {
                System.out.println("Wrong date format!");
            }
        }

        System.out.print("EngineCapacity : ");
        this.EngineCapacity = scanner.nextFloat();
    }

    public void Print(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String releaseDate = (Release != null) ? formatter.format(Release) : "N/A";

        System.out.print(
                "{"
                        + "Name - " + Name + ", "
                        + "Manufacturer - " + Manufacturer + ", "
                        + "Release - " + releaseDate + ", "
                        + "EngineCapacity - " + EngineCapacity
                        + "}\n"
        );
    }

    public String getName() {
        return Name;
    }

    public Date getRelease() {
        return Release;
    }

    public float getEngineCapacity() {
        return EngineCapacity;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setRelease(Date release) {
        Release = release;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEngineCapacity(float engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
}
