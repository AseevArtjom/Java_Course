import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task4
{
    public static class Projector{
        private String Name;
        private LocalDate DateOfProduction;
        private Double Cost;
        private String Manufacturer;

        public Projector(String name,LocalDate dateOfProduction,Double cost,String manufacturer){
            this.Name = name;
            this.DateOfProduction = dateOfProduction;
            this.Cost = cost;
            this.Manufacturer = manufacturer;
        }

        @Override
        public String toString() {
            return "Projector{" +
                    "Name='" + Name + '\'' +
                    ", DateOfProduction=" + DateOfProduction +
                    ", Cost=" + Cost +
                    ", Manufacturer='" + Manufacturer + '\'' +
                    '}';
        }

        public String getName() {
            return Name;
        }

        public String getManufacturer() {
            return Manufacturer;
        }

        public Double getCost() {
            return Cost;
        }

        public LocalDate getDateOfProduction() {
            return DateOfProduction;
        }

        public void setDateOfProduction(LocalDate dateOfProduction) {
            DateOfProduction = dateOfProduction;
        }

        public void setCost(Double cost) {
            Cost = cost;
        }

        public void setName(String name) {
            Name = name;
        }

        public void setManufacturer(String manufacturer) {
            Manufacturer = manufacturer;
        }
    }

    public static void main(String[] args) {
        List<Projector> projectors = Arrays.asList(
                new Projector("Epson EH-TW8000", LocalDate.of(2024, 6, 15), 1500.00, "Epson"),
                new Projector("Epson EH-TW7100", LocalDate.of(2020, 6, 15), 1200.00, "Epson"),
                new Projector("Epson EH-TW5100", LocalDate.of(2019, 6, 15), 1100.00, "Epson"),
                new Projector("Epson EH-TW2100", LocalDate.of(2018, 6, 15), 1000.00, "Epson"),
                new Projector("BenQ TK800M", LocalDate.of(2019, 4, 10), 1500.00, "BenQ"),
                new Projector("Optoma UHD60", LocalDate.of(2021, 1, 25), 2000.00, "Optoma"),
                new Projector("ViewSonic PX747-4K", LocalDate.of(2020, 11, 5), 1100.00, "ViewSonic"),
                new Projector("LG PF50KA", LocalDate.of(2021, 8, 19), 500.00, "LG")
        );

        System.out.println("Projectors : ");
        projectors.forEach(projector -> System.out.println(projector.toString()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the manufacturer : ");
        String manufacturer = scanner.nextLine();
        List<Projector> projectorsWithSameManufacturer = projectors.stream()
                .filter(projector -> projector.getManufacturer().equalsIgnoreCase(manufacturer))
                .toList();
        projectorsWithSameManufacturer.forEach(projector -> System.out.println(projector.toString()));

        System.out.print("Projectors produced in current year : ");
        int CurrentYear = LocalDate.now().getYear();
        List<Projector> projectorsByCurrentYear = projectors.stream()
                .filter(projector -> projector.getDateOfProduction().getYear() == CurrentYear)
                .toList();
        projectorsByCurrentYear.forEach(projector -> System.out.println(projector.toString()));

        System.out.print("Enter cost : ");
        double Cost = scanner.nextDouble();
        List<Projector> projectorsBiggerCost = projectors.stream()
                .filter(projector -> projector.getCost() > Cost)
                .toList();
        projectorsBiggerCost.forEach(projector -> System.out.println(projector.toString()));

        System.out.println("Sorted by highest cost : ");
        List<Projector> projectorsByHighestCost = projectors.stream()
                .sorted((p1, p2) -> p2.getCost().compareTo(p1.getCost()))
                .toList();
        projectorsByHighestCost.forEach(projector -> System.out.println(projector.toString()));

        System.out.println("Sorted by lowest cost : ");
        List<Projector> projectorsByLowestCost = projectors.stream()
                .sorted((p1, p2) -> p1.getCost().compareTo(p2.getCost()))
                .toList();
        projectorsByLowestCost.forEach(projector -> System.out.println(projector.toString()));

        System.out.println("Sorted by highest year : ");
        List<Projector> projectorsByHighestYear = projectors.stream()
                .sorted((p1,p2) -> Integer.compare(p2.getDateOfProduction().getYear(),p1.getDateOfProduction().getYear()))
                .toList();
        projectorsByHighestYear.forEach(projector -> System.out.println(projector.toString()));

        System.out.println("Sorted by lowest year : ");
        List<Projector> projectorsByLowestYear = projectors.stream()
                .sorted((p1,p2) -> Integer.compare(p1.getDateOfProduction().getYear(),p2.getDateOfProduction().getYear()))
                .toList();
        projectorsByHighestYear.forEach(projector -> System.out.println(projector.toString()));
    }
}
