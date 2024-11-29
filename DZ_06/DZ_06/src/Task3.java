import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static class Device {
        private String name;
        private LocalDate dateOfProduction;
        private double cost;
        private String type;
        private String color;

        public Device(String name, LocalDate dateOfProduction, double cost, String color, String type) {
            this.name = name;
            this.dateOfProduction = dateOfProduction;
            this.cost = cost;
            this.color = color;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public LocalDate getDateOfProduction() {
            return dateOfProduction;
        }

        public double getCost() {
            return cost;
        }

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "name='" + name + '\'' +
                    ", dateOfProduction=" + dateOfProduction +
                    ", cost=" + cost +
                    ", color='" + color + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Device> devices = Arrays.asList(
                new Device("iPhone", LocalDate.of(2020, 10, 1), 999.99, "Black", "Smartphone"),
                new Device("Samsung A55", LocalDate.of(2023, 10, 1), 899.99, "White", "Smartphone"),
                new Device("Samsung TV", LocalDate.of(2019, 5, 15), 1500.00, "Silver", "TV"),
                new Device("MacBook Pro", LocalDate.of(2021, 7, 20), 2500.00, "Gray", "Laptop"),
                new Device("PlayStation 5", LocalDate.of(2020, 11, 12), 499.99, "White", "Console"),
                new Device("Dell Monitor", LocalDate.of(2018, 3, 10), 300.00, "Black", "Monitor")
        );

        System.out.println("All devices:");
        devices.forEach(device -> System.out.println(device.toString()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose color : ");
        String Color = scanner.nextLine();
        List<Device> devicesByColor = devices.stream().filter(device -> device.color.equalsIgnoreCase(Color)).toList();
        System.out.println("Devices by " + Color + " color : ");
        devicesByColor.forEach(device -> System.out.println(device.toString()));


        System.out.print("Enter year of production: ");
        int year = Integer.parseInt(scanner.nextLine());
        List<Device> devicesByYear = devices.stream()
                .filter(device -> device.getDateOfProduction().getYear() == year)
                .toList();
        System.out.println("Devices from " + year + " year : " );
        devicesByYear.forEach(device -> System.out.println(device.toString()));

        System.out.print("Enter cost : ");
        Double CostInput = scanner.nextDouble();
        List<Device> devicesBiggerCost = devices.stream()
                .filter(device -> device.getCost() > CostInput)
                .toList();
        devicesBiggerCost.forEach(device -> System.out.println(device.toString()));

        System.out.print("Enter device type : ");
        scanner.nextLine();
        String DeviceType = scanner.nextLine();
        List<Device> devicesByType = devices.stream()
                .filter(device -> device.getType().equalsIgnoreCase(DeviceType))
                .toList();
        devicesByType.forEach(device -> System.out.println(device.toString()));

        int FirstYear = 0;
        int SecondYear = 0;
        do {
            System.out.println("Enter date range : ");
            System.out.print("From ");
            FirstYear = scanner.nextInt();
            System.out.print("to ");
            SecondYear = scanner.nextInt();
        }while (FirstYear > SecondYear);

        int finalFirstYear = FirstYear;
        int finalSecondYear = SecondYear;
        List<Device> devicesByYearRange = devices.stream()
                .filter(device -> device.getDateOfProduction().getYear() >= finalFirstYear && device.getDateOfProduction().getYear() <= finalSecondYear)
                .toList();
        devicesByYearRange.forEach(device -> System.out.println(device.toString()));
    }
}