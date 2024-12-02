import java.io.*;
import java.util.*;

public class Task5 {
    private static List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the file path to load employees: ");
        String filePath = "DZ_07/src/" + scanner.nextLine();
        loadEmployeesFromFile(filePath);

        while (true) {
            System.out.println("\n--- Corporation System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee by Last Name");
            System.out.println("5. Display Employees");
            System.out.println("6. Save Employees to File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> editEmployee();
                case 3 -> deleteEmployee();
                case 4 -> searchEmployee();
                case 5 -> displayEmployees();
                case 6 -> saveEmployeesToFile(filePath);
                case 7 -> {
                    saveEmployeesToFile(filePath);
                    System.out.println("Exiting and saving employees...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        employees.add(new Employee(firstName, lastName, age));
        System.out.println("Employee added");
    }

    private static void editEmployee() {
        System.out.print("Enter last name of the employee to edit: ");
        String lastName = scanner.nextLine();
        Employee employee = findEmployeeByLastName(lastName);
        if (employee == null) {
            System.out.println("Employee not found");
            return;
        }

        System.out.print("Enter new first name (leave empty to keep current): ");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isBlank()) {
            employee.setFirstName(newFirstName);
        }

        System.out.print("Enter new last name (leave empty to keep current): ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isBlank()) {
            employee.setLastName(newLastName);
        }

        System.out.print("Enter new age (enter 0 to keep current): ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        if (newAge > 0) {
            employee.setAge(newAge);
        }

        System.out.println("Employee updated");
    }

    private static void deleteEmployee() {
        System.out.print("Enter last name of the employee to delete: ");
        String lastName = scanner.nextLine();
        Employee employee = findEmployeeByLastName(lastName);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        Employee employee = findEmployeeByLastName(lastName);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found");
        }
    }

    private static void displayEmployees() {
        System.out.println("1. All employees");
        System.out.println("2. Employees of a specific age");
        System.out.println("3. Employees whose last name starts with a specific letter");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> employees.forEach(System.out::println);
            case 2 -> {
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                employees.stream()
                        .filter(e -> e.getAge() == age)
                        .forEach(System.out::println);
            }
            case 3 -> {
                System.out.print("Enter starting letter: ");
                String letter = scanner.nextLine().toLowerCase();
                employees.stream()
                        .filter(e -> e.getLastName().toLowerCase().startsWith(letter))
                        .forEach(System.out::println);
            }
            default -> System.out.println("Invalid option");
        }
    }

    private static void loadEmployeesFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found. Starting with an empty list");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    employees.add(new Employee(parts[0], parts[1], Integer.parseInt(parts[2])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void saveEmployeesToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                writer.write(employee.toShort());
                writer.newLine();
            }
            System.out.println("Employees saved to file");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private static Employee findEmployeeByLastName(String lastName) {
        return employees.stream()
                .filter(e -> e.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}


