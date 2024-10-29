package model;

import java.util.Date;
import java.util.Scanner;

public class Human
{
    private String Fio;
    private String birthday;
    private String country;
    private String city;
    private String address;

    public  Human(){}

    public Human(String fio,String birthday,String country,String city,String address){
        this.Fio = fio;
        this.birthday = birthday;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public void InputData(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("FIO : ");
        this.Fio = scanner.nextLine();

        System.out.print("Birthday : ");
        this.birthday = scanner.nextLine();

        System.out.print("Country : ");
        this.country = scanner.nextLine();

        System.out.print("City : ");
        this.city = scanner.nextLine();

        System.out.print("Address : ");
        this.address = scanner.nextLine();
    }

    public void printData(){
        System.out.print(
                "{"
              + "Fio - " + Fio + ","
              + "Birthday - "  + birthday + ","
              + "Country - "  + country + ","
              + "City - "  + city + ","
              + "Address - "  + address
              + "}\n"
        );
    }

    public String getFio(){
        return Fio;
    }

    public String getBirthday(){
        return  birthday;
    }

    public String getCountry(){
        return country;
    }

    public String getCity(){
        return city;
    }

    public String getAddress(){
        return address;
    }

    public void setFio(String Fio){
        this.Fio = Fio;
    }
    public void setBirthday(String Birthday){
        this.birthday = birthday;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
