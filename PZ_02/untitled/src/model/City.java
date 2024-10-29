package model;

import java.util.Scanner;

public class City
{
    private String Name;
    private String Region;
    private String Country;
    private int Population;
    private long MailIndex;
    private int PhoneCode;

    public City() {}

    public City(String name,String region,String country,int population,long mailIndex,int phoneCode){
        this.Name = name;
        this.Region = region;
        this.Country = country;
        this.Population = population;
        this.MailIndex = mailIndex;
        this.PhoneCode = phoneCode;
    }

    public void InputData(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of the city : ");
        this.Name = scanner.nextLine();

        System.out.print("Region : ");
        this.Region = scanner.nextLine();

        System.out.print("Country : ");
        this.Country = scanner.nextLine();

        System.out.print("Population : ");
        this.Population = scanner.nextInt();

        System.out.print("MailIndex : ");
        this.MailIndex = scanner.nextLong();

        System.out.print("PhoneCode : ");
        this.PhoneCode = scanner.nextInt();
    }

    public void printData(){
        System.out.print(
                "{"
                        + "Name - " + Name + ","
                        + "Region - "  + Region + ","
                        + "Country - "  + Country + ","
                        + "Population - "  + Population + ","
                        + "MailIndex - "  + MailIndex + ","
                        + "PhoneCode - "  + PhoneCode
                        + "}\n"
        );
    }

    public String getName(){
        return Name;
    }
    public String getCountry(){
        return Country;
    }
    public String getRegion(){
        return Region;
    }
    public int getPopulation(){
        return Population;
    }
    public int getPhoneCode(){
        return PhoneCode;
    }
    public long getMailIndex(){
        return MailIndex;
    }

    public void setName(String name){
        this.Name = name;
    }
    public void setCountry(String country){
        this.Country = country;
    }
    public void setRegion(String region){
        this.Region = region;
    }
    public void setPopulation(int population){
        this.Population = population;
    }
    public void setMailIndex(long mailIndex){
        this.MailIndex = mailIndex;
    }
    public void setPhoneCode(int phoneCode){
        this.PhoneCode = phoneCode;
    }
}
